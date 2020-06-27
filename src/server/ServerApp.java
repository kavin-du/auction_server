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
		ServerSocket ss = new ServerSocket(2000);        // close this
		int threads = Runtime.getRuntime().availableProcessors(); // number of processors available in system
		System.out.println(threads);
		int counter = 0;
		while(counter < threads) {
			Socket s = ss.accept(); // create new server thread each time
			ServerThreads serverthread = new ServerThreads(s, counter);
			serverthread.start();
			counter ++;
		}
		ss.close();
		// close ss, server socket
	}
	
	
 
}
