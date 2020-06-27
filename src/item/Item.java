package item;

import java.util.ArrayList;
import java.util.Random;

import modules.Bid;

public class Item {
	private String symbol;
	private String securityName;
	private int price;
	
	private ArrayList<Bid> variation;  // variation of the bids for given item
	
	public static Random rand = new Random(); // to generate random prices
	
	public Item(String symbol, String securityName) {
		this.symbol = symbol;
		this.securityName = securityName;
		this.price = rand.nextInt((2000-500)+1)+500; // generate prices between 500 and 2000
		this.variation = new ArrayList<>();
		
	}
	
	@Override
	public String toString() {
		return this.symbol+" "+this.securityName+" "+this.price;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	public String getSecurityName() {
		return this.securityName;
	}
	public int getPrice() {
		return this.price;
	}
	public synchronized void setPrice(Bid bid) {  // making this synchronize so other thread can't write at the same time
		this.price = bid.getPrice();
		this.variation.add(bid);
	}
	
	public void printVariation() {   // printing variation over the time
		for(Bid bid : this.variation) {
			System.out.println(bid);
		}
	}
	
	
	
}