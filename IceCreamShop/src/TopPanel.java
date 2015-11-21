import javax.swing. *;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import javax.swing.JFrame;
public class TopPanel extends JPanel implements ActionListener
{
	IceCreamMaker maker;
	IceCreamLineManager iceCreamLine;
	private int score;
	private JLabel label;
	StackLL<String> makerStack; //a stack to hold what we've made 
	StackLL<String> lineStack; //a stack to hold the ice cream in line

	public TopPanel(Graphics g) 
	{
		super(); //turns itself into a JLabel
		//JPanel topPanel= new JPanel();
		
		this.setLayout(new GridLayout(2,1));
		
	//	JLabel instructions= new JLabel();
		//instructions.setText("Testing the instructions");
		label=makeJLabel();
	//	this.add(instructions);
		this.add(label);
		
		//then make a JButton "Serve Order"
		JButton serveOrder= new JButton("Serve Order");
		serveOrder.addActionListener(this);
		
		//add the JButton to the topPanel
		this.add(serveOrder);
		//after we've add everything we've need to add we add topPanel to the frame
		maker= new IceCreamMaker(g);
		iceCreamLine= new IceCreamLineManager();
	}
	public JLabel makeJLabel()
	{
		JLabel instructions= new JLabel();
		instructions.setText("Score:"+score);
		//label=instructions;
		return instructions;
	}
	public void updateLabel()
	{
		label.setText("Score:"+score);
	}
	
	public IceCreamLineManager getIceCreamLine()
	{
		return iceCreamLine;
	}
	public IceCreamMaker getMaker()
	{
		return maker;
	}
	public void actionPerformed(ActionEvent e)
	{
		String buttonPressed=e.getActionCommand();
		if(buttonPressed.equals("Serve Order")) //when we press serve order
		{
		
			//if the line is not empty
			if(!iceCreamLine.getLine().getJQueue().isEmpty()) //$$$$$ NEWLY ADDED $$$$$$
			{
			
				if(checkMatch()==true) //if it is a match
				{
					score+=10;
					updateLabel();
					
					//System.out.println("&&&&& The stack of ice cream I made looks like &&&&& "+ makerStack.toString());
					removeBothIceCreams();
					
				
				
				
				
				}
				
				else //when it isnt a match
				{
					//System.out.println("!!!!!BEFORE &&&&& The stack of ice cream I made looks like &&&&& "+ makerStack.toString());
					score-=5;
					
					updateLabel();
					
					System.out.println("BEFORE &&&&& The stack of ice cream I made looks like &&&&& "+ makerStack.toString());
					removeBothIceCreams() ;
					System.out.println("AFTER &&&&&&& The stack of ice cream I made looks like &&&&" +makerStack.toString());
					
					
					
					
				}
			}
			
			
			
		}
		
	}
	public boolean checkMatch() /**check to see if the ice cream in line is the same as ice cream ordered**/
	{
		/**these two need to be global**/
		 makerStack= maker.getCone().getLogicCone(); 
		
	
		 lineStack=iceCreamLine.getLine().getCurrentIceCream().getLogic();
		 System.out.println("Before this SHIT the stack we made looks like "+makerStack.toString());
		
		
		StackLL<String> tempStackMaker= new StackLL<String>(); //the temporary stack that is going to push whatever makerStack popped off
		
		StackLL<String> tempStackLine=new StackLL<String>();
		//System.out.println("Do the two ice creams have the same number of scoops "+(makerStack.getLength()==lineStack.getLength()));
		if(makerStack.getLength()==lineStack.getLength())
		{
			while(!makerStack.isEmpty()&&!lineStack.isEmpty() ) //and the number of scoops in each stack is equal
			{
			//
			//maker.getCone().trashScoop();
				String tempMaker= makerStack.pop(); 
			
				tempStackMaker.push(tempMaker); //then I push it onto a new stack
			
				String tempLine=lineStack.pop();
			
				tempStackLine.push(tempLine);//push it onto a new stack
				
			
				if(!tempMaker.equals(tempLine)) //if at a single place it is not the same
				{
					while(!tempStackLine.isEmpty()&&!tempStackMaker.isEmpty()) //have makerStack and lineStack look the way it did
					{
						makerStack.push(tempStackMaker.pop());
						lineStack.push(tempStackLine.pop());
						
					}
				
					
					//the stack in line does not look like what it should
					System.out.println("After all this SHIT the stack we made is "+ makerStack.toString());
				//IF THEY ARE NOT THE SAME WE STILL HAVE TO PRESERVE WHAT THE TWO ORIGINAL STACKS LOOK LIKE
					return false;
				}
			}
			
			
		}
		else //when they have different number of scoops return false because they are obviously not equal
		{
			return false;
		}
		
		//lineStack=tempStackLine;
		//makerStack=tempStackMaker;
		/** when we try to preserve our lineStack and our makerStack we are doing it wrong because I am actually reassigning to them the reverse of**/
		
		while(!tempStackLine.isEmpty())
		{
			lineStack.push(tempStackLine.pop());
			
		}
		//System.out.println("!After all the manipulations the stack in line looks like "+ lineStack.toString());
		while(!tempStackMaker.isEmpty())
		{
			makerStack.push(tempStackMaker.pop());
		}
		//System.out.println("$After all the manipulations the stack we made looks like "+ makerStack.toString());
		
		
		return true;
	}
	
	public void removeBothIceCreams()
	{
		
		/** remove the ice cream that we've made**/
		//System.out.println("The stack we make when we call removeBothIceCreams looks like "+ makerStack.toString());
		while(!makerStack.isEmpty())
		{
			maker.getCone().trashScoop();
			//trash scoop also pops stuff
		}
		//System.out.println("After we've trashed everything the stack we made looks like " + makerStack.toString());
		
		iceCreamLine.getLine().removeFirstOrder(); //remove what's in line
			
	}
}























