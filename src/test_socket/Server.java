package test_socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		int port = 5555;
		
		// create server socket
		ServerSocket ss = new ServerSocket(port);
		
		Socket socket = ss.accept();
		
		// create output stream
		OutputStream s1out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);
		
		// utf-8 encode
		dos.writeUTF("This is server...");
		System.out.println("server is running"); // not working..?
		// close connections
		dos.close();
		s1out.close();
		socket.close();
	}
}
