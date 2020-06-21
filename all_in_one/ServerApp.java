
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerApp {

	public static ArrayList<Item> items = new ArrayList<>();   // list for store the readed items

	public static void main(String[] args) throws IOException {
		
		ReadFile.readFile(items);	
		GUI.guiBegin();
		
		// creating server
		ServerSocket ss = new ServerSocket(2000);
		
		int counter = 0;
		while(counter < 2) {
			Socket s = ss.accept();
			ServerThreads serverthread = new ServerThreads(s, counter);
			serverthread.start();
			counter ++;
		}
		
		// close ss, server socket
		
		
		//==========================================================================================
		
//		DataInputStream din = new DataInputStream(s.getInputStream()); // reading from client
//		DataOutputStream dout = new DataOutputStream(s.getOutputStream()); // write back to client
//		
////		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reading from console, not yet
//		
//		dout.writeUTF("Enter your Name:");
//		dout.flush();
//		String clientName = din.readUTF(); // store this ------- done
//		
////		System.out.println("Your name is " + clientName);
//		
//		dout.writeUTF("Enter symbol: ");
//		dout.flush();
//		String symbol = din.readUTF();
//		
//		int currentCost = -1;  // if not found, return -1
//		
//		for(Item item : items) {
//			if(item.getSymbol().contentEquals(symbol)) {
//				currentCost = item.getPrice();
//			}
//		}
//		
//		dout.writeUTF(Integer.toString(currentCost));
//		dout.flush();
//		
//		if(currentCost >= 0) {
//			dout.writeUTF("Enter your bid:");
//			dout.flush();
//			
//			int bidPrice = Integer.valueOf(din.readUTF());
//			for(Item item : items) {
//				if(item.getSymbol().equals(symbol)) {
//					item.setPrice(new Bid(clientName, bidPrice));
////					System.out.println("bid set "+ bidPrice);
//					item.printVariation();
//				}
//			}
//			
//		}
//		
//		din.close();
//		dout.close();
//		s.close();
//		ss.close();
		
		// ===================================================================================================
		
	}
	
	
 
}
