package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Timer;

import item.Item;
import modules.GUI;
import modules.ReadFile;

public class ServerApp {

	public static ArrayList<Item> items = new ArrayList<>();   // list for store the readed items

	public static void main(String[] args) throws IOException {
//		static ArrayList<Item> items = new ArrayList<>();   // list for store the readed items
		
		ReadFile.readFile(items);	
		GUI.guiBegin();
		
		// creating server
		ServerSocket ss = new ServerSocket(2000);
		Socket s = ss.accept();
		
		DataInputStream din = new DataInputStream(s.getInputStream()); // reading from client
		DataOutputStream dout = new DataOutputStream(s.getOutputStream()); // write back to client
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reading from console
		
		dout.writeUTF("Enter your Name:");
		dout.flush();
		String clientName = din.readUTF(); // store this -------
		
//		System.out.println("Your name is " + clientName);
		
		dout.writeUTF("Enter symbol: ");
		dout.flush();
		String symbol = din.readUTF();
		
		int currentCost = -1;
		
		for(Item item : items) {
			if(item.getSymbol().contentEquals(symbol)) {
				currentCost = item.getPrice();
			}
		}
		
		dout.writeUTF(Integer.toString(currentCost));
		dout.flush();
		
		if(currentCost >= 0) {
			dout.writeUTF("Enter your bid:");
			dout.flush();
			
			int bid = Integer.valueOf(din.readUTF());
			for(Item item : items) {
				if(item.getSymbol().equals(symbol)) {
					item.setPrice(bid);
					System.out.println("bid set "+ bid);
				}
			}
			
		}
		
		din.close();
		dout.close();
		s.close();
		ss.close();
		
	}
	
	
 
}
