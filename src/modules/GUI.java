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
import javax.swing.JTextField;
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
        

        JButton label1 = new JButton("<html>"+"Symbol: <font color=purple>FB</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(FB).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(FB).getPrice()+"</font></html>");
        JButton label2 = new JButton("<html>"+"Symbol: <font color=purple>VRTU</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(VRTU).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(VRTU).getPrice()+"</font></html>");
        JButton label3 = new JButton("<html>"+"Symbol: <font color=purple>MSFT</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(MSFT).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(MSFT).getPrice()+"</font></html>");
        JButton label4 = new JButton("<html>"+"Symbol: <font color=purple>GOOGL</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(GOOGL).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(GOOGL).getPrice()+"</font></html>");
        JButton label5 = new JButton("<html>"+"Symbol: <font color=purple>YHOO</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(YHOO).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(YHOO).getPrice()+"</font></html>");
        JButton label6 = new JButton("<html>"+"Symbol: <font color=purple>XLNX</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(XLNX).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(XLNX).getPrice()+"</font></html>");
        JButton label7 = new JButton("<html>"+"Symbol: <font color=purple>TSLA</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(TSLA).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(TSLA).getPrice()+"</font></html>");
        JButton label8 = new JButton("<html>"+"Symbol: <font color=purple>TXN</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(TXN).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(TXN).getPrice()+"</font></html>");
          
        label1.setBounds(10, 10, 200, 200);
        label2.setBounds(220, 10, 200, 200);
        label3.setBounds(430, 10, 200, 200);
        label4.setBounds(640, 10, 200, 200);
        label5.setBounds(10, 220, 200, 200);
        label6.setBounds(220, 220, 200, 200);
        label7.setBounds(430, 220, 200, 200);
        label8.setBounds(640, 220, 200, 200);
        
        label1.setFont(new Font("Arial", Font.BOLD, 15)); // set font and font size
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        label4.setFont(new Font("Arial", Font.BOLD, 15));
        label5.setFont(new Font("Arial", Font.BOLD, 15));
        label6.setFont(new Font("Arial", Font.BOLD, 15));
        label7.setFont(new Font("Arial", Font.BOLD, 15));
        label8.setFont(new Font("Arial", Font.BOLD, 15));        

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);



        // adding search box

        JLabel tracklabel = new JLabel("Enter a symbol to track bid history.");
        tracklabel.setBounds(300, 440, 250, 30);
        panel.add(tracklabel);

        JTextField tf = new JTextField();
        tf.setBounds(320, 480, 210, 30);
        panel.add(tf);

        JButton track = new JButton("Track");
        track.setBounds(375, 520, 100, 30);
        track.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame trackFrame = new JFrame("Bid History");
                trackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // close without terminating the program

                JPanel trackPanel = new JPanel();
                trackPanel.setVisible(true);
                trackPanel.setLayout(null);

                JLabel trackValues = new JLabel();
                String value = tf.getText();
                if(!value.isEmpty()){
                    
                    String trackHistory = "<html> Enter a valid symbol! <br>Check whether letters are capital.</html>";
                    for(Item item : ServerApp.items){
                        if(item.getSymbol().equals(value)){
                            trackHistory = item.getVariation();
                        }
                    }



                    trackValues.setText(trackHistory);
                    trackValues.setBounds(10,10,790,490);

                    trackPanel.add(trackValues);

                    trackFrame.add(trackPanel);
                    trackFrame.setPreferredSize(new Dimension(800,500));
                    trackFrame.pack();
                    trackFrame.setLocationRelativeTo(null); // start window in center of screen
                    trackFrame.setVisible(true);
                }
            }
                
                
        });
        panel.add(track);







        
        frame.add(panel); // add label to frame
        frame.setPreferredSize(new Dimension(860,700));
        frame.pack();
        frame.setLocationRelativeTo(null); // start window in center of screen
        frame.setVisible(true);
        
        ActionListener actlis  = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		label1.setText("<html>"+"Symbol: <font color=purple>FB</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(FB).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(FB).getPrice()+"</font></html>");
                label2.setText("<html>"+"Symbol: <font color=purple>VRTU</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(VRTU).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(VRTU).getPrice()+"</font></html>");
                label3.setText("<html>"+"Symbol: <font color=purple>MSFT</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(MSFT).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(MSFT).getPrice()+"</font></html>");
                label4.setText("<html>"+"Symbol: <font color=purple>GOOGL</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(GOOGL).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(GOOGL).getPrice()+"</font></html>");
                label5.setText("<html>"+"Symbol: <font color=purple>YHOO</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(YHOO).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(YHOO).getPrice()+"</font></html>");
                label6.setText("<html>"+"Symbol: <font color=purple>XLNX</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(XLNX).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(XLNX).getPrice()+"</font></html>");
                label7.setText("<html>"+"Symbol: <font color=purple>TSLA</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(TSLA).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(TSLA).getPrice()+"</font></html>");
                label8.setText("<html>"+"Symbol: <font color=purple>TXN</font>"+"<br>"+"Company: "+"<font color='teal'>"+ServerApp.items.get(TXN).getSecurityName()+"</font>"+"<br>"+"Price: <font color=blue>$"+ServerApp.items.get(TXN).getPrice()+"</font></html>");
                
                // label1.repaint();
        		
        	}			
        };
        
        
        Timer timer = new Timer(500, actlis);
		
        timer.start();
    }

	
}
