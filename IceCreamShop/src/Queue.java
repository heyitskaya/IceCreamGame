
public interface Queue <T>
{
	//remove from head
	//add to end
	
	public void enqueue(T data); //add to end
	
	public T dequeue(); //remove from head
	
	public T peek(); //take a look at the what's at the end
	
	public boolean isEmpty();
	
	public String toString();
	
	
	
}
