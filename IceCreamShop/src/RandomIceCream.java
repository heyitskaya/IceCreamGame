import javax.swing.*;

import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics.*; //import all of java graphics

public class RandomIceCream extends JComponent
{
	public static int FRAME_WIDTH=300;
	public static int FRAME_LENGTH=300;
	private static int radius = 20;
	private int conesDrawn;
	
	private StackLL<String> logicCone= new StackLL<String>(); //the stack
	private int numScoops;

	public RandomIceCream()
	{
		super(); 
		addRandomOrder(); 
		repaint();
		
	}
	
	public void paint(Graphics g)
	{
		//go through the queue and paint every one
		
		drawCone(g);
		drawScoop(g);
		
	}
	public StackLL<String> getLogic()
	{
		System.out.println("We're in getLogic()");
		return logicCone;
	}
	
	public int randomScoops() //makes a random number of scoops
	{
		int i=(int)(Math.random()*4+1);
		
		
		return i; //makes an int from 1~4
		
				
		
	}
	
	public String makeRandomFlavor()
	{
		int i=(int)(Math.random()*4);
		if(i==0)
		{
			return "vanilla";
		}
		else if(i==1)
		{
			return "strawberry";
		}
		else if(i==2)
		{
			return "green tea";
		}
		else 
		{
			return "burnt caramel";
		}
	}
	//need to add stuff to our queue
	public StackLL<String> addRandomOrder() /** adds an order to the q**/
	//should return a stack, the stack of the random order we just made
	{
		
		StackLL<String> temp= new StackLL<String>(); //this doesn't need to be a queue at all
		int numScoops=randomScoops();
		for(int j=0;j<numScoops;j++) //changed numScoops to 1
		{
			
			
			String flavor= makeRandomFlavor();
			
			temp.push(flavor); //push it onto the stack
			
		}
		
		logicCone=temp;
		
		
		
		return temp;
		
		
	}
	
	/**public void removeFirstOrder()
	{
		q.dequeue(); 
	}**/
	
	public void drawIceCream(StackLL<String> stack,Graphics g) //takes in a stack
	{
		//but first, lemme draw a cone
		//drawCone(g);
		drawScoop(g);
		
		
		
		
	}
	
	public void drawCone(Graphics g) {

		g.setColor(Color.ORANGE);
		
		g.fillPolygon(new int[] { FRAME_WIDTH / 2, FRAME_WIDTH / 2 - 15,
				FRAME_WIDTH / 2 + 15 }, new int[] { FRAME_LENGTH - 80,
				FRAME_LENGTH - 150, FRAME_LENGTH - 150 }, 3);

		
	}
	
	public void drawScoop(Graphics g) {
		
		conesDrawn = 0;
		StackLL<String> tempCone = new StackLL<String>();

		while (!logicCone.isEmpty()) {
			
			tempCone.push(logicCone.pop()); // pop things from the logicCone and
			

		}
		while (!tempCone.isEmpty()) {

			logicCone.push(tempCone.pop());
			
			String flavorToAdd = logicCone.peek();
			conesDrawn++;

			// -------NEWLY ADDED--------

			if (flavorToAdd == null) {
				// if the stack is empty do nothing
			} else if (flavorToAdd.equals("vanilla")) {
				g.setColor(Color.YELLOW);

				g.fillOval(FRAME_WIDTH / 2 - 20, FRAME_LENGTH - 140 - conesDrawn
						* radius * 2, radius * 2, radius * 2);

			} else if (flavorToAdd.equals("strawberry")) {
				g.setColor(Color.PINK);
				g.fillOval(FRAME_WIDTH / 2 - 20, FRAME_LENGTH - 140 - conesDrawn
						* radius * 2, radius * 2, radius * 2);
			} else if (flavorToAdd.equals("green tea")) {
				g.setColor(Color.GREEN);
				g.fillOval(FRAME_WIDTH / 2 - 20, FRAME_LENGTH - 140 - conesDrawn
						* radius * 2, radius * 2, radius * 2);

			} else if (flavorToAdd.equals("burnt caramel")) {
				g.setColor(Color.ORANGE);
				g.fillOval(FRAME_WIDTH / 2 - 20, FRAME_LENGTH - 140 - conesDrawn
						* radius * 2, radius * 2, radius * 2);

			}
		}
	}
	
	

}
