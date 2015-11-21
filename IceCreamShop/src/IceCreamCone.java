import java.lang.Math;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.*;

public class IceCreamCone extends JComponent {
	private StackLL<String> logicCone = new StackLL<String>();

	private int conesDrawn = 0;
	private static int radius = 25;
	private static int FRAME_LENGTH = 800;
	private static int FRAME_WIDTH = 600;
	private boolean trash;

	public IceCreamCone(Graphics g) // draw a cone with GUI
	{
		super();
		
	}

	public void addScoop(String flavor) // i call addScoop everytime I press a
										// button so I need to call drawScoop in
										// addScoop
	{
		conesDrawn++; //increment the cones drawn
		logicCone.push(flavor); //push the string flavor onto the stack
		

		repaint(); // call repain to repaint everything
	}
	

	public void addScoop() /** Generate a random number, depending on what that number is we push a corresponding flavor onto the stack**/
	{
		int i = (int) Math.random() * 4;  //generate a random number
		if (i == 0) 
		{
			logicCone.push("vanilla"); 
		} 
		else if (i == 1) 
		{
			logicCone.push("strawberry");
		} 
		else if (i == 2) 
		{
			logicCone.push("green tea");
		} 
		else 
		{
			logicCone.push("burnt caramel");
		}

	}

	public void paint(Graphics g)  //call drawCone and drawScoop
	{ 

		drawCone(g);
		drawScoop(g);
		

	}

	public void drawCone(Graphics g) 
	{

		g.setColor(Color.ORANGE);
		
		g.fillPolygon(new int[] { FRAME_WIDTH / 2, FRAME_WIDTH / 2 - 20,
				FRAME_WIDTH / 2 + 20 }, new int[] { FRAME_LENGTH - 120,
				FRAME_LENGTH - 180, FRAME_LENGTH - 180 }, 3);
		/**An alternate way to draw the cone is g.fillPolygon(new int[] { FRAME_WIDTH / 2, FRAME_WIDTH / 2 - 15,
				FRAME_WIDTH / 2 + 15 }, new int[] { FRAME_LENGTH - 80,
				FRAME_LENGTH - 150, FRAME_LENGTH - 150 }, 3);**/

		
	}

	public void drawScoop(Graphics g) /** takes in parameter Graohics g and draws a single scoop**/
	{
		conesDrawn = 0;
		StackLL<String> tempCone = new StackLL<String>();

		while (!logicCone.isEmpty()) {
			
			tempCone.push(logicCone.pop()); // pop things from the logicCone and
											// push to the tempCone
		
		
		}
		while (!tempCone.isEmpty()) //when the cone is not yet empty 
		{

			logicCone.push(tempCone.pop());
			
			String flavorToAdd = logicCone.peek(); //get what flavor we should add by using method peek
			conesDrawn++;

			
			if (flavorToAdd == null) 
			{
				// if the stack is empty do nothing
			} 
			else if (flavorToAdd.equals("vanilla")) //when we actually have a flavor we want to push
			{
				g.setColor(Color.YELLOW); //first we set the color

				g.fillOval(FRAME_WIDTH / 2 - 25, FRAME_LENGTH - 170 - conesDrawn  //then we draw a circle
						* radius * 2, radius * 2, radius * 2);

			} 
			else if (flavorToAdd.equals("strawberry")) 
			{
				g.setColor(Color.PINK);
				g.fillOval(FRAME_WIDTH / 2 - 25, FRAME_LENGTH - 170 - conesDrawn
						* radius * 2, radius * 2, radius * 2);
			} 
			else if (flavorToAdd.equals("green tea")) 
			{
				g.setColor(Color.GREEN);
				g.fillOval(FRAME_WIDTH / 2 - 25, FRAME_LENGTH - 170 - conesDrawn
						* radius * 2, radius * 2, radius * 2);

			} else if (flavorToAdd.equals("burnt caramel")) {
				g.setColor(Color.ORANGE);
				g.fillOval(FRAME_WIDTH / 2 - 25, FRAME_LENGTH - 170 - conesDrawn
						* radius * 2, radius * 2, radius * 2);

			}
		}

		
	}

	public void trashScoop() 
	{
		
		trash=true; 
		if (!logicCone.isEmpty())  //we only trash when the logicCone is not empty
		{
			logicCone.pop(); //pop if from the logicCone
			
			repaint(); //repaint
			
		} 
		else 
		{
			// do nothing
		}
	}
	
	public StackLL<String> getLogicCone() /**getter for private variable logicCone**/
	{
		return logicCone;
	}

}
