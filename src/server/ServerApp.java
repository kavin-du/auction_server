package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import item.Item;
import modules.GUI;
import modules.ReadFile;

public class ServerApp {

	public static ArrayList<Item> items = new ArrayList<>();   // list for store the readed items

	public static void main(String[] args) throws IOException {
		
		ReadFile.readFile(items);	
		GUI.guiBegin(); 
		
		// creating server
		ServerSocket ss = new ServerSocket(2000);
		int counter = 0;
		while(counter < 2) {
			Socket s = ss.accept(); // create new server thread each time
			ServerThreads serverthread = new ServerThreads(s, counter);
			serverthread.start();
			counter ++;
		}
		
		// close ss, server socket
	}
	
	
 
}
