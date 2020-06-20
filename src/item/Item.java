package item;

public class Item {
	private String symbol;
	private String securityName;
	private int price;
	
	
	public Item(String symbol, String securityName, int price) {
		this.symbol = symbol;
		this.securityName = securityName;
		this.price = price;
		
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
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}