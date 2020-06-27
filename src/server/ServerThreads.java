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
	
	private BufferedReader br;
	private DataOutputStream dout;
	
	private String clientName;
	private String symbol;
	private int currentCost;
	
	public ServerThreads(Socket s, int counter) {
		this.s = s;
		this.counter = counter;
		this.currentCost = -1; // initial cost of a symbol is set to -1, so if NO matching symbol found, -1 can be send to client
	}
	
	@Override
	public void run() {
		try {
			this.br = new BufferedReader(new InputStreamReader(this.s.getInputStream(), "UTF-8")); // reading from client
			this.dout = new DataOutputStream(this.s.getOutputStream()); // write back to client
			
			
			System.out.println(""+counter+" client started"); // print in server
			
			this.dout.writeUTF(""+counter+" client started\n"); // print in client
			this.dout.flush();
			
			this.dout.writeUTF("Enter your Name:\n");
			this.dout.flush();
			
			this.clientName = this.br.readLine();
			
			sendSymbolAndPrice();
			
			if(this.currentCost >= 0) {
				startBidding();
				
			}

			br.close();
//			dout.close();
//			s.close();   // server only close socket, client close in and out
		} catch (Exception e) {  
//			System.out.println(e); // also close the connections
			System.out.println(""+counter+" client exited.");
		}
	}
	
	public void sendSymbolAndPrice() throws Exception {
		this.dout.writeUTF("Enter symbol: \n");
		this.dout.flush();
		this.symbol = this.br.readLine();
		
		for(Item item : ServerApp.items) {
			if(item.getSymbol().contentEquals(this.symbol)) {
				this.currentCost = item.getPrice();
			}
		}
		
		this.dout.writeUTF(Integer.toString(currentCost));
		this.dout.flush();
		
		
	}
	
	public void startBidding() throws Exception {
		while(true) {
			this.dout.writeUTF("\nEnter your bid: \nChange company-> change \nExit-> exit\n");
//			this.dout.writeChars("Enter your bid: \nChange company-> change \nExit-> exit\n");
			this.dout.flush();
			
			String clientEntered =this.br.readLine();
			if(clientEntered.equals("exit")) {
				break;
			} else if (clientEntered.equals("change")) {
				sendSymbolAndPrice();
				
//				clientEntered = this.br.readLine(); // taking client input again
				continue; // continue without executing below codes
			}
			
			int bidPrice = Integer.valueOf(clientEntered);   
			for(Item item : ServerApp.items) {
				if(item.getSymbol().equals(this.symbol)) {
					item.setPrice(new Bid(this.clientName, bidPrice));
					item.printVariation();
				}
			}
			
		}
	}
	
	
}
