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

public class IceCreamMaker extends JPanel implements ActionListener
//where we implement the GUI
{
	private static int FRAME_LENGTH=800; //used to be 800
	private static int FRAME_WIDTH=600;
	private IceCreamCone cone;
	private static Graphics g;
	
	public static void main (String[] args) {
//		Graphics g;
		IceCreamMaker maker = new IceCreamMaker(g);
		JFrame frame= new JFrame("Testing ice cream maker");
		frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
		frame.add(maker);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true);
		
	}
	
	
	
	public IceCreamMaker(Graphics g)
	{
		
		
		//make a JPanel
		//JPanel bigPanel= new JPanel();
		this.setLayout(new BorderLayout());
		cone=new IceCreamCone(g);
		cone.setVisible(true);
		this.add(cone, BorderLayout.CENTER);
		
		//the buttonPanel will  get added to north of big panel
		JPanel buttonPanel= new JPanel();
		buttonPanel.setLayout(new BorderLayout()); 
		
		JPanel flavorPanel= new JPanel(); //this flavorPanel will be added to the north of the buttonPanel
		flavorPanel.setLayout(new GridLayout(1,4)); //make this a gridLayout 1 row and 4 columns
		//make the four buttons and add them to the flavor panel
		JButton vanillaButton= new JButton("vanilla");
		vanillaButton.addActionListener(this);
		
		JButton strawberryButton= new JButton("strawberry");
		strawberryButton.addActionListener(this);
		
		JButton greenTeaButton= new JButton("green tea");
		greenTeaButton.addActionListener(this);
	
		JButton burntCaramelButton= new JButton("burnt caramel");
		burntCaramelButton.addActionListener(this); 
		
		flavorPanel.add(vanillaButton);
		flavorPanel.add(strawberryButton);
		flavorPanel.add(greenTeaButton);
		flavorPanel.add(burntCaramelButton);
		//add flavorPanel to the north of button panel
		buttonPanel.add(flavorPanel,BorderLayout.NORTH); //add the grid layout containing four buttons to the north of the button panel
		
		//make a trash button
		
		JButton trashButton= new JButton("Trash the top scoop");
		trashButton.addActionListener(this);
		
		buttonPanel.add(trashButton, BorderLayout.CENTER);
		
		//instantiate the ice cream cone class and add it to the center of the bigPanel !!!!
		
		
		//then we add button panel to the north of the our big jpanel
		this.add(buttonPanel,BorderLayout.NORTH);
		//first make a JFrame
		
		
	/**	JFrame frame= new JFrame("Ice Cream Maker");
		frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true);**/
		
		
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonPressed=e.getActionCommand();
		
		if(buttonPressed.equals("vanilla"))
		{
			cone.addScoop("vanilla");
			//System.out.println(buttonPressed);
		}
		else if (buttonPressed.equals("strawberry"))
		{
			cone.addScoop("strawberry");
			//System.out.println(buttonPressed);
		}
		else if(buttonPressed.equals("green tea"))
		{
			cone.addScoop("green tea");
			//System.out.println(buttonPressed);
		}
		else if(buttonPressed.equals("burnt caramel"))
		{
			cone.addScoop("burnt caramel");
			//System.out.println(buttonPressed);
		}
		else if(buttonPressed.equals("Trash the top scoop"))
		{
			//trash the top scoop
			cone.trashScoop();
			//System.out.println("The top scoop has been trashed");		
			}
				
		
		
	}
	public IceCreamCone getCone()
	{
		return cone;
	}

}
