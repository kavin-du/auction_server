package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 2000);
		
		DataInputStream din = new DataInputStream(s.getInputStream()); // read from server
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // read from console
		
		System.out.print(din.readUTF());// printing "client started"
		System.out.print(din.readUTF());  // printing "enter your name: "
		
		String name = br.readLine(); // reading client name from console
//		System.out.println(name+" sfsdfs");
		dout.writeUTF(name); // send name to the server
		dout.flush();
		
		System.out.print(din.readUTF()); // printing "enter symbol"
		
		String symbol = br.readLine(); // reading symbol from console
		
		dout.writeUTF(symbol); // send symbol to server
		dout.flush();
		
		int response = Integer.valueOf(din.readUTF());
		System.out.println("Response is "+response);
		
		if(response >= 0) {
			System.out.print(din.readUTF()); // server incoming, "enter your bid: "
			
			
			dout.writeUTF(br.readLine()); // read bid from console and send to server
			dout.flush();
		}
		
		
		/// should not be closed when multi threading -- test without closing
		
//		dout.close();
//		din.close();
//		s.close();

	}

}
