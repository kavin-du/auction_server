package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import item.Item;
import modules.Bid;

public class ServerThreads extends Thread {
	
	private Socket s;
	private int counter;
	
	public ServerThreads(Socket s, int counter) {
		this.s = s;
		this.counter = counter;
		
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(this.s.getInputStream())); // reading from client
			DataOutputStream dout = new DataOutputStream(this.s.getOutputStream()); // write back to client
			
			
//			DataInputStream din = new DataInputStream(this.s.getInputStream()); // read from server
			
			
			
	//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reading from console, not yet
			System.out.println(""+counter+" client started"); // print in server
			
			dout.writeUTF(""+counter+" client started\n"); // print in client
			dout.flush();
			
			dout.writeUTF("Enter your Name:\n");
			dout.flush();
			
//			String clientName = din.readUTF();
//			System.out.println("Your name is " + name2);
			
			String clientName = br.readLine();
//			
//			System.out.println("Your name is " + clientName);
			
			dout.writeUTF("Enter symbol: \n");
			dout.flush();
			String symbol = br.readLine();
//			String symbol = din.readUTF();
			
			int currentCost = -1;  // if not found, return -1
			
			for(Item item : ServerApp.items) {
				if(item.getSymbol().contentEquals(symbol)) {
					currentCost = item.getPrice();
				}
			}
			
			dout.writeUTF(Integer.toString(currentCost));
			dout.flush();
			
			if(currentCost >= 0) {
				dout.writeUTF("Enter your bid:\n");
				dout.flush();
				
				int bidPrice = Integer.valueOf(br.readLine());   // readutf here
//				int bidPrice = Integer.valueOf(din.readUTF());   
				for(Item item : ServerApp.items) {
					if(item.getSymbol().equals(symbol)) {
						item.setPrice(new Bid(clientName, bidPrice));
	//					System.out.println("bid set "+ bidPrice);
						item.printVariation();
					}
				}
				
			}
			
//			din.close();
//			dout.close();
//			s.close();
	//		ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
}
