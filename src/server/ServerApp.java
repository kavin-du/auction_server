package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import item.Item;
import modules.GUI;
import modules.ReadFile;

/*
* This class handles the server side and creating seperate
* threads for each client
*
*/

public class ServerApp {

	public static ArrayList<Item> items = new ArrayList<>();   // list for store the readed items

	public static void main(String[] args) throws IOException {
		
		ReadFile.readFile(items);	
		GUI.guiBegin(); // start gui of stock market
		
		// creating server
		ServerSocket ss = new ServerSocket(2000); 
		int threads = Runtime.getRuntime().availableProcessors(); // number of processors available in system
		// System.out.println(threads);
		int counter = 1;
		while(counter <= threads) {
			Socket s = ss.accept(); // create new server thread each time
			ServerThreads serverthread = new ServerThreads(s, counter); // passing socket and client number
			serverthread.start();
			counter ++;
		}
		ss.close();
	}
	
	
 
}
