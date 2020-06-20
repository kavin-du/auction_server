package test_socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverName = "localhost";
		int port = 5555;
		
		Socket client = new Socket(serverName, port);
		
		// read input stream
		InputStream inputss = client.getInputStream();
		DataInputStream dis = new DataInputStream(inputss);
		
		String st = new String(dis.readUTF());
		
		System.out.println(st);
		
		// close connection
		dis.close();
		inputss.close();
		client.close();

	}

}
