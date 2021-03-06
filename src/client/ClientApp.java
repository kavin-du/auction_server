package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 2000);
		
		BufferedReader din = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8")); // reading from server
		
		PrintWriter dout = new PrintWriter(
				new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream(), "UTF-8")
				), true);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // read from console
		
		System.out.println(din.readLine());// ----printing "client started"
		System.out.println(din.readLine());  // ---printing "enter your name: "
		
		String name = br.readLine(); // reading client name from console
		dout.println(name); // -----send name to server
		dout.flush(); 
		
		outerloop: 
		while(true) {
			String server = din.readLine();
			while(din.ready()) {
				System.out.println(server);// printing "enter symbol"
				server = din.readLine();
			}
		
			String symbol = br.readLine(); // reading symbol from console
			
			dout.println(symbol); // send symbol to server
			dout.flush();
			
			int response = Integer.valueOf(din.readLine());
			System.out.println("Response is "+response);
			if(response >= 0){
				while(true){
					String line = din.readLine(); // enter bid or change or exit
					while(din.ready()){
						System.out.println(line);
						line = din.readLine();
					}
					
					String clientEntered = br.readLine(); // BID, CHANGE, EXIT
					
					dout.println(clientEntered); // read bid from console and send to server
					dout.flush();
					
					if(clientEntered.equals("exit")) {
						break outerloop;
					} else if(clientEntered.equals("change")) {
						break;
					}	

				}
				
			} else {
				continue;
			}
		}
		
		dout.close();
		din.close();
		s.close();

	}

}
