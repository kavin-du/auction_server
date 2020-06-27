package item;

import java.util.ArrayList;
import java.util.Random;

import modules.Bid;

public class Item {
	private String symbol;
	private String securityName;
	private int price;
	private int availableLots;

	
	private ArrayList<Bid> variation;  // variation of the bids for given item
	
	public static Random rand = new Random(); // to generate random prices
	
	public Item(String symbol, String securityName, int availableLots) {
		this.symbol = symbol;
		this.securityName = securityName;
		this.availableLots = availableLots;
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
	public int getAvailableLots(){
		return this.availableLots;
	}
	public synchronized void setPrice(Bid bid) {  // making this synchronize so other thread can't write at the same time
		this.price = bid.getPrice();
		this.variation.add(bid);
	}
	
	public String getVariation() {   // printing variation over the time
		String value = "<html>";
		if(this.variation.isEmpty()){
			return "No one has bid for this symbol yet!";
		}
		for(Bid bid : this.variation) {
			value += "Company: <font color=teal>"+this.securityName+"</font>, "+bid+"<br>";			
		}
		// System.out.println(value);
		value += "</html>";
		return value;
	}
	
	
	
}