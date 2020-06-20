package modules;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import item.Item;
import server.ServerApp;

public class GUI{
	
	// indexes for symbols
	static int FB = -99; 
	static int VRTU = -99;
	static int MSFT = -99;
	static int GOOGL = -99;
	static int YHOO = -99;
	static int XLNX = -99;
	static int TSLA = -99;
	static int TXN = -99;
	
	public static void guiBegin() {
		
		for(int i=0; i< ServerApp.items.size(); i++) {
			if(ServerApp.items.get(i).getSymbol().equals("FB")) {
				FB = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("VRTU")) {
				VRTU = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("MSFT")) {
				MSFT = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("GOOGL")) {
				GOOGL = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("YHOO")) {
				YHOO = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("XLNX")) {
				XLNX = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("TSLA")) {
				TSLA = i;
			} else if(ServerApp.items.get(i).getSymbol().equals("TXN")) {
				TXN = i;
			}
		}
		
//		System.out.printf("%d %d %d %d %d %d %d %d", FB,VRTU,MSFT,GOOGL,YHOO,XLNX,TSLA,TXN);
		
		JFrame frame = new JFrame("Auction Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(); // buttons are placed in panel
        panel.setVisible(true);
        panel.setLayout(null);
        

        JButton label1 = new JButton("<html>"+"FB"+"<br>"+ServerApp.items.get(FB).getPrice()+"</html>");
        JButton label2 = new JButton("<html>"+"VRTU"+"<br>"+ServerApp.items.get(VRTU).getPrice()+"</html>");
        JButton label3 = new JButton("<html>"+"MSFT"+"<br>"+ServerApp.items.get(MSFT).getPrice()+"</html>");
        JButton label4 = new JButton("<html>"+"GOOGL"+"<br>"+ServerApp.items.get(GOOGL).getPrice()+"</html>");
        JButton label5 = new JButton("<html>"+"YHOO"+"<br>"+ServerApp.items.get(YHOO).getPrice()+"</html>");
        JButton label6 = new JButton("<html>"+"XLNX"+"<br>"+ServerApp.items.get(XLNX).getPrice()+"</html>");
        JButton label7 = new JButton("<html>"+"TSLA"+"<br>"+ServerApp.items.get(TSLA).getPrice()+"</html>");
        JButton label8 = new JButton("<html>"+"TXN"+"<br>"+ServerApp.items.get(TXN).getPrice()+"</html>");
        
//        JLabel label1 = new JLabel("<html>"+"FB"+"<br>"+items.get(FB).getPrice()+"</html>");
//        JLabel label2 = new JLabel("<html>"+"VRTU"+"<br>"+items.get(VRTU).getPrice()+"</html>");
//        JLabel label3 = new JLabel("<html>"+"MSFT"+"<br>"+items.get(MSFT).getPrice()+"</html>");
//        JLabel label4 = new JLabel("<html>"+"GOOGL"+"<br>"+items.get(GOOGL).getPrice()+"</html>");
//        JLabel label5 = new JLabel("<html>"+"YHOO"+"<br>"+items.get(YHOO).getPrice()+"</html>");
//        JLabel label6 = new JLabel("<html>"+"XLNX"+"<br>"+items.get(XLNX).getPrice()+"</html>");
//        JLabel label7 = new JLabel("<html>"+"TSLA"+"<br>"+items.get(TSLA).getPrice()+"</html>");
//        JLabel label8 = new JLabel("<html>"+"TXN"+"<br>"+items.get(TXN).getPrice()+"</html>");
        
        label1.setBounds(10, 10, 120, 120);
        label2.setBounds(140, 10, 120, 120);
        label3.setBounds(270, 10, 120, 120);
        label4.setBounds(400, 10, 120, 120);
        label5.setBounds(10, 140, 120, 120);
        label6.setBounds(140, 140, 120, 120);
        label7.setBounds(270, 140, 120, 120);
        label8.setBounds(400, 140, 120, 120);
        
        label1.setFont(new Font("Arial", Font.BOLD, 20)); // set font and font size
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label4.setFont(new Font("Arial", Font.BOLD, 20));
        label5.setFont(new Font("Arial", Font.BOLD, 20));
        label6.setFont(new Font("Arial", Font.BOLD, 20));
        label7.setFont(new Font("Arial", Font.BOLD, 20));
        label8.setFont(new Font("Arial", Font.BOLD, 20));        

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        
        frame.add(panel); // add label to frame
        frame.setPreferredSize(new Dimension(540,300));
        frame.pack();
        frame.setLocationRelativeTo(null); // start window in center of screen
        frame.setVisible(true);
        
        ActionListener actlis  = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		label1.setText("<html>"+"FB"+"<br>"+ServerApp.items.get(FB).getPrice()+"</html>");
        		label2.setText("<html>"+"VRTU"+"<br>"+ServerApp.items.get(VRTU).getPrice()+"</html>");
        		label3.setText("<html>"+"MSFT"+"<br>"+ServerApp.items.get(MSFT).getPrice()+"</html>");
        		label4.setText("<html>"+"GOOGL"+"<br>"+ServerApp.items.get(GOOGL).getPrice()+"</html>");
        		label5.setText("<html>"+"YHOO"+"<br>"+ServerApp.items.get(YHOO).getPrice()+"</html>");
        		label6.setText("<html>"+"XLNX"+"<br>"+ServerApp.items.get(XLNX).getPrice()+"</html>");
        		label7.setText("<html>"+"TSLA"+"<br>"+ServerApp.items.get(TSLA).getPrice()+"</html>");
        		label8.setText("<html>"+"TXN"+"<br>"+ServerApp.items.get(TXN).getPrice()+"</html>");
//        		label1.repaint();
        		
        	}			
        };
        
        
        Timer timer = new Timer(500, actlis);
		
		
		timer.start();
	}
	
	
}
