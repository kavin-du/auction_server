package item;

import java.util.ArrayList;

import modules.Bid;

public class Item {
	private String symbol;
	private String securityName;
	private int price;
	
	private ArrayList<Bid> variation;  // variation of the bids for given item
	
	
	public Item(String symbol, String securityName, int price) {
		this.symbol = symbol;
		this.securityName = securityName;
		this.price = price;
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
	public void setPrice(Bid bid) {
		this.price = bid.getPrice();
		this.variation.add(bid);
	}
	
	public void printVariation() {   // printing variation over the time
		for(Bid bid : this.variation) {
			System.out.println(bid);
		}
	}
	
	
	
}