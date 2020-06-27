package modules;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * When client place a bid for particular company, details about the client, price
 * and time will be stored by objects of this class.
 * This will keep track of the bid history of each company in the stock market
 */

public class Bid {
	
	private String clientName;
	private int bidPrice;
	private LocalDateTime dateTime; // date and time of the bidding event
	
	public Bid(String clientName, int bidPrice) {
		this.clientName = clientName;
		this.bidPrice = bidPrice;
		this.dateTime = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  // format the date
		return "Client Name: <font color=green>"+this.clientName + "</font> ,Bid: <font color=blue>$" + this.bidPrice + "</font> ,Time: <font color=purple>" + dtf.format(this.dateTime)+"</font>";
	}
	
	public int getPrice() {
		return this.bidPrice;
	}
	
	
	
}
