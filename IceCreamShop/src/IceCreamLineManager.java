import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class IceCreamLineManager extends JPanel implements ActionListener
{
	public static int FRAME_WIDTH=300;
	public static int FRAME_LENGTH=800;
	private IceCreamLine line; //RECENTLY COMMENTED
	
/**	public static void main(String[] args)
	{
		JFrame frame= new JFrame("Testing for line");
		frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
		
		
		
		IceCreamLineManager q= new IceCreamLineManager();
		frame.add(q);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true);
		
	}**/
	
	public IceCreamLineManager()
	{
		super();
		//make a big panel
		
		this.setLayout(new BorderLayout()); //bigPanel will have a borderLayout with the buttonPanel added to the north
		
		line= new IceCreamLine(); 
		
		
		 // ---------don't forget to add the line to the bigPanel-----
		//make a button panel to add the buttons
		JPanel buttonPanel= new JPanel(); //buttonPanel will be a gridLayout 
		buttonPanel.setLayout(new GridLayout(2,1));
		
		//make button "Add a random order"
		JButton randomOrder= new JButton("Add a random order");
		randomOrder.addActionListener(this);
		//add this JButton onto the buttonPanel
		buttonPanel.add(randomOrder);
		
		//make button "Serve the next order"
		JButton nextOrder= new JButton("Serve the next order");
		nextOrder.addActionListener(this);
		//add this JButton to the buttonPanel
		buttonPanel.add(nextOrder);
		
		//add our buttonPanel to the bigPanel
		this.add(buttonPanel, BorderLayout.NORTH);
		this.add(line,BorderLayout.CENTER);
		
		//make a JFrame just to test i
	/**	JFrame frame= new JFrame("Ice Cream Maker");
		frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
		frame.add(bigPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true);
		**/
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		String buttonPressed=e.getActionCommand();
		if(buttonPressed.equals("Add a random order"))
		{
			line.addToLine();
			
			
		}
		else if(buttonPressed.equals("Serve the next order"))
		{
			
			line.removeFirstOrder();
			System.out.println("Serve the next order");
		}
		
	}
	public IceCreamLine getLine()
	{
		System.out.println("We're in getLine()");
		return line;
	}
	
	
	

}
