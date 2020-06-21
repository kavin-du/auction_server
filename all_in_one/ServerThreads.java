
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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
			DataInputStream din = new DataInputStream(this.s.getInputStream()); // reading from client
			DataOutputStream dout = new DataOutputStream(this.s.getOutputStream()); // write back to client
			
	//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reading from console, not yet
			
			System.out.println(""+counter+" client started");
			//dout.flush();
			
			dout.writeUTF("Enter your Name:");
			dout.flush();
			String clientName = din.readUTF(); // store this ------- done
			
	//		System.out.println("Your name is " + clientName);
			
			dout.writeUTF("Enter symbol: ");
			dout.flush();
			String symbol = din.readUTF();
			
			int currentCost = -1;  // if not found, return -1
			
			for(Item item : ServerApp.items) {
				if(item.getSymbol().contentEquals(symbol)) {
					currentCost = item.getPrice();
				}
			}
			
			dout.writeUTF(Integer.toString(currentCost));
			dout.flush();
			
			if(currentCost >= 0) {
				dout.writeUTF("Enter your bid:");
				dout.flush();
				
				int bidPrice = Integer.valueOf(din.readUTF());
				for(Item item : ServerApp.items) {
					if(item.getSymbol().equals(symbol)) {
						item.setPrice(new Bid(clientName, bidPrice));
	//					System.out.println("bid set "+ bidPrice);
						item.printVariation();
					}
				}
				
			}
			
			din.close();
			dout.close();
			s.close();
	//		ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
}
