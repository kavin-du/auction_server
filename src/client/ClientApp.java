package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 2000);
		
		// DataInputStream din = new DataInputStream(s.getInputStream()); // read from server
		BufferedReader din = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8")); // reading from server
//		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		PrintWriter dout = new PrintWriter(
				new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream(), "UTF-8")
				), true);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // read from console
		
		System.out.println(din.readLine());// printing "client started"
		System.out.println(din.readLine());  // printing "enter your name: "
		
		String name = br.readLine(); // reading client name from console
//		dout.writeUTF(name); // send name to the server
		dout.println(name);
//		dout.flush(); // auto flush enabled ?? 
		
		System.out.print(din.readLine()); // printing "enter symbol"
		
		String symbol = br.readLine(); // reading symbol from console
		
		dout.println(symbol); // send symbol to server
//		dout.flush();
		
		int response = Integer.valueOf(din.readLine());
		System.out.println("Response is "+response);
		
		if(response >= 0) {
			while(true) {
				String line = din.readLine();
				while(din.ready()){
					System.out.println(line);
					line = din.readLine();
				}
				// System.out.println(din.readLine()); // server incoming, "enter your bid: or change or close"
				
				String clientEntered = br.readLine();
				
				dout.println(clientEntered); // read bid from console and send to server
				dout.flush();
				
				if(clientEntered.equals("exit")) {
					break;
				} else if(clientEntered.equals("change")) {
					System.out.print(din.readLine()); // printing "enter symbol"
					
					symbol = br.readLine(); // reading symbol from console
					
//					dout.writeUTF(symbol); // send symbol to server
					dout.println(symbol);
//					dout.flush();
					
					response = Integer.valueOf(din.readLine());
					System.out.println("Response is "+response);
					continue;
				}
				
				
			}
		}
		
		
		/// should not be closed when multi threading -- test without closing
		
		dout.close();
		din.close();
		s.close();

	}

}
