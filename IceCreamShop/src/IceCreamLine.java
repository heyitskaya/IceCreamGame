import javax.swing.*;

import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics.*; //import all of java graphics


public class IceCreamLine extends JPanel //this class is a JPanel itself
{
	public static int FRAME_WIDTH=300;
	public static int FRAME_LENGTH=800;
	private static int radius = 20;
	private int conesDrawn;
	QueueLL<StackLL<String>> q= new QueueLL<StackLL<String>>(); //our queue takes in a stack
	StackLL<String> logicCone= new StackLL<String>(); //the stack
	private int numScoops;
	RandomIceCream currentIceCream;
	
	private QueueLL<JComponent> JQueue= new QueueLL<JComponent>();

	public IceCreamLine() /** in the constructor we turn the class into a JPanel when we instantiate this class and set the layout to BoxLayout**/
	{
		super(); //turns itself into a JPanel
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //set this JPanel to have a boxLayout
		
	}
	public void addToLine() //** add a JComponent to the queue and paints it**/
	{
		
		currentIceCream=new RandomIceCream(); //make a new ice cream which is of type JComponent
		
		JQueue.enqueue(currentIceCream); //enter the JComponent into the queue
		this.add(currentIceCream); //add the JComponent to the queue
		
		validate(); //validate and repaint it
		repaint();

		
	}
	public RandomIceCream getCurrentIceCream() /** getter for current icecream**/
	{
		
		currentIceCream = (RandomIceCream) JQueue.peek();
		return currentIceCream;
	}
	public void removeFirstOrder() /** removes the order that is at the front of the queue**/
	{
		if(!JQueue.isEmpty()) //we only try to remove when the queue is not empty**/
		{
			this.remove(JQueue.dequeue());
			currentIceCream=(RandomIceCream) JQueue.peek();
			validate();
			
			repaint(); //validate and repaint it
		}
	}
	public QueueLL<JComponent> getJQueue() /** getter for JQueue**/
	{
		return JQueue;
	}
	public StackLL<String> getLogicCone() /** getter for logicCone**/
	{
		return logicCone;
	}
	
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

