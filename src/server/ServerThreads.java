package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import item.Item;
import modules.Bid;

/**
 * This class act as independant thread server
 * for each client.
 */

public class ServerThreads extends Thread {
	
	private Socket s;
	private int counter;
	
	private BufferedReader br;

	private PrintWriter dout;
	
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

			this.dout = new PrintWriter(
				new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream(), "UTF-8")
				), true);
			
			
			System.out.println("client "+counter+" started"); // print in server
			
			this.dout.print("client "+counter+" started\n"); // ----print in client
			this.dout.flush();
			
			this.dout.print("Enter your Name:\n");
			this.dout.flush();
			
			this.clientName = this.br.readLine(); 
			System.out.println("client name is "+this.clientName); 
						
			while(true){
				sendSymbolAndPrice();
				if(this.currentCost >= 0) {
					startBidding();
					break;					
				} else { // no matching company found
					continue;
				}
			}

			br.close();
			dout.close();
			s.close(); 
		} catch (Exception e) {  
			System.out.println("Error creating client "+counter+" "+e);
		} finally {
			System.out.println("client "+counter+" exited.");
		}
	}
	
	/*
	this function get client input and send symbol and price whenever client connect 
	for the first time	and whenever client changes the bidding company
	*/
	public void sendSymbolAndPrice() throws Exception {
		this.dout.println("Enter symbol: \n");
		this.dout.flush();
		this.symbol = this.br.readLine();
		this.currentCost = -1; // making current cost of symbol as -1, so if there is no matching symbol -1 will be sent
		
		for(Item item : ServerApp.items) {
			if(item.getSymbol().contentEquals(this.symbol)) {
				this.currentCost = item.getPrice();
			}
		}
		
		this.dout.println(Integer.toString(currentCost)); // sending cost to the client
		this.dout.flush();
		
	}
	
	/*
		After client enter a valid symbol, this function starts the bidding process
		for that particular symbol, clients can change their bidding symbol
		if they want.

	*/

	public void startBidding() throws Exception {
		while(true) {
			this.dout.println("\nEnter your bid: \nChange company-> change \nExit-> exit\n>>\n");
			this.dout.flush();
			
			String clientEntered =this.br.readLine(); // reading user input
			if(clientEntered.equals("exit")) {
				break;
			} else if (clientEntered.equals("change")) {
				this.currentCost = -1;
				while(this.currentCost < 0){
					sendSymbolAndPrice(); // send symbol until matching company found
				}
				continue; // continue without executing below codes
			}
			
			int bidPrice = Integer.valueOf(clientEntered);   
			for(Item item : ServerApp.items) {
				if(item.getSymbol().equals(this.symbol)) {
					item.setPrice(new Bid(this.clientName, bidPrice)); // set bid price according to the client
				}
			}
			
		}
	}
	
	
}
