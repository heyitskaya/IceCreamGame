import javax.swing. *;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JFrame;

public class IceCreamApplication /** This is the class where we piece everthing together**/
{
	private static Graphics g;
	private IceCreamLineManager iceCreamLine; //this is a JPanel
	private IceCreamMaker maker; //this is a JPanel
	public IceCreamApplication(Graphics g)  /** Our constructor takes in Graphics as parameter**/
	{
		
		
		JFrame frame= new JFrame("Kaya's Ice Cream Shop"); //create a JFrame and give it a name
		frame.setSize(900,842);
		
		frame.setLayout(new BorderLayout()); //set the frame to a borderLayout
		
		TopPanel topPanel= new TopPanel(g); //instantiate our topPanel class
	
		iceCreamLine=topPanel.getIceCreamLine(); //get the iceCreamLine from out TopPanel class
		JPanel bottomPanel = new JPanel(); //create a new JPanel that'll hold our ice cream maker and our queue
		
		bottomPanel.setLayout(new GridLayout(1,2)); //set the layout to be gridLayout 1 row 2 columns

		bottomPanel.add(iceCreamLine); //add the iceCream line
		maker= topPanel.getMaker();
		bottomPanel.add(maker);
		
		frame.add(topPanel,BorderLayout.NORTH); //add the topPanel of the game to the north of our borderLayout
		frame.add(bottomPanel, BorderLayout.CENTER); //add the bottomPanel of the game to the center of our borderLayout
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true); //set visible to true
		
		
	}

	public static void main(String[] args)
	{
		IceCreamApplication k= new IceCreamApplication(g); //instantiate our class and let the games begin
	}
	

}
