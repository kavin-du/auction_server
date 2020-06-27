package modules;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bid {
	
	private String clientName;
	private int bidPrice;
	private LocalDateTime dateTime;
	
	public Bid(String clientName, int bidPrice) {
		this.clientName = clientName;
		this.bidPrice = bidPrice;
		this.dateTime = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		return "Client Name: <font color=green>"+this.clientName + "</font> ,Bid: <font color=blue>$" + this.bidPrice + "</font> ,Time: <font color=purple>" + dtf.format(this.dateTime)+"</font>";
	}
	
	public int getPrice() {
		return this.bidPrice;
	}
	
	
	
}
