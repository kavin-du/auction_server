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
		
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(din.readUTF());  // server incoming
		
		String name = br.readLine();
		
		dout.writeUTF(name);
		dout.flush();
		
		System.out.println(din.readUTF()); // server incoming
		
		String symbol = br.readLine();
		
		dout.writeUTF(symbol);
		dout.flush();
		
		int response = Integer.valueOf(din.readUTF());
		System.out.println("Response is "+response);
		
		if(response >= 0) {
			System.out.println(din.readUTF()); // server incoming
			
			dout.writeUTF(br.readLine());
			dout.flush();
		}
		
		
		/// should not be closed when multi threading -- test without closing
		
		dout.close();
		din.close();
		s.close();

	}

}
