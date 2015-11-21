
public class QueueLL <T> implements Queue<T>
{
	LinkedList<T> l;
	public QueueLL()
	{
		l= new LinkedList<T>();
	}
	
	public void enqueue(T data) //add to end
	{
		l.insertLast(data);
	}
	public T dequeue() //remove from head and returns data of the node we removeed
	{
		//ALWAYS CHECK IF THE LIST IS EMPTY BEFORE CALLING DEQUEUE
		LinkedListNode<T> node= l.getFirstNode(); //get the first node of the linked list
		l.deleteFirst();
		
		return node.getData();
	}
	
	public T peek() //take a look at the what's at the front
	{
		return l.getFirst();
	}
	
	public boolean isEmpty()
	{
		return l.isEmpty();
	}
	public String toString()
	{
		return l.toString();
	}

}
