
public class StackLL<T> implements Stack<T>
{
	LinkedList<T> l;
	public StackLL()
	{
		l= new LinkedList<T>();
		
	}
	
	public void push(T data)
	{
		
		l.insertFirst(data);
		
	}
	public T pop() //returns the data of the node we popped
	{
		T data= l.getFirst();
		l.deleteFirst();
		return data;
	}
	
	public T peek()
	{
		T data= l.getFirst();
		return data;
	}
	
	
	
	
	public boolean isEmpty()
	{
		return l.isEmpty();
		
	}
	public String toString()
	{
		if(l.isEmpty())
		{
			return null;
		}
		else 
		{
			return l.toString();
		}
	}
	public int getLength()
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=l.getFirstNode();
		int length=0;
		if(isEmpty())
		{
			return 0;
		}
		while(cursor!=null)
		{
			cursor=cursor.getNext();
			length++;
		}
		return length;
	}
	
	
	

}
