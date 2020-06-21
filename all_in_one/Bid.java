
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
		return "Client Name: "+this.clientName + " ,Bid: " + this.bidPrice + " ,Time: " + dtf.format(this.dateTime);
	}
	
	public int getPrice() {
		return this.bidPrice;
	}
	
	
	
}
