
public class LinkedList<T>
{
	private LinkedListNode<T> head; //head node
	public LinkedList() /** the constructor**/
	{
		head=null; //initialize the head to null
		 
	}
	
	public T getFirst() /** get the data of the head of this list**/
	{
		if(head!=null) //if the head is not null
		{
			return head.getData(); //return the data stored in head
		}
		else
		{
			
			return null; //else return null because our head is null
		}
	}

	public LinkedListNode<T> getFirstNode() /** get head node of the list**/
	{
		if(head!=null)
		{
			return head;
		}
		else
		{
			
			return null;
		}
		
	}
	public T getLast() //get the data stored in the tail node of the list
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=head; //have cursor start traversing from head
		if(head==null) //if the list is empty
		{
			return null;
		}
		while(cursor.getNext()!=null)
		{
			cursor=cursor.getNext(); //keep on moving down the list
		}
		//when the next one is null that means we've reached the end of our list
		return cursor.getData();
	}
	
	public LinkedListNode<T> getLastNode() /** get the tail node of the list**/
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=head; //have cursor start traversing from head
		if(head==null)
		{
			return null;
		}
		while(cursor.getNext()!=null)
		{
			cursor=cursor.getNext(); //keep on moving down the list
		}
		//when the next one is null that means we've reached the end of our list
		return cursor;
		
	}
	//THIS IS WORKING
	
	public void insertFirst(T data) //insert a new node with data at the head
	{
		LinkedListNode<T> newNode= new LinkedListNode<T>();
		newNode.setData(data); //make a new node and set the data
		newNode.setNext(head); //have newNode point to the next node head points to 
		head=newNode;
		
	}
	public void insertAfter(LinkedListNode<T> currentNode, T data) /** make a node with the data and add this node after the currentNode**/
	{
		LinkedListNode<T> newNode= new LinkedListNode<T>(); //make a new node with the data
		newNode.setData(data);
		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		LinkedListNode<T> temp= new LinkedListNode<T>();
		while( cursor!=null) //when we haven't found the node and can still traverse
			// linked list
		{
			//cursor=cursor.getNext();
			if(cursor.equals(currentNode)) //when we have found the node we are looking for
			{
				temp=cursor.getNext(); //get the node after cursor node
				cursor.setNext(newNode); //have cursor point to currentNode
				newNode.setNext(temp); //then have currentNode point to temp
			}
			cursor=cursor.getNext(); //move the cursor down the list
		}
		
	}
	public void insertLast(T data) /** insert a new node with data at the tail of this list**/
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		LinkedListNode<T> node= new LinkedListNode<T>();
		if(head==null) //if the list is empty
		{
			insertFirst(data);
		}
		else
		{
			while(cursor.getNext()!=null)
			{
				cursor=cursor.getNext(); 
			}
		//once we have gotten out of the while loop cursor references the last node
			insertAfter(cursor,data);
		}
		
		
	}
	public void deleteFirst() /** remove the first node**/
	{
		if(head==null)
		{
			System.out.println("null");
		}
		
		head=head.getNext(); //have head equal to the one after it
		
	}
	//maybe look at this again
	public void deleteLast() /**remove the last node**/
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		while(cursor.getNext().getNext()!=null) 
		{
			cursor=cursor.getNext();
			
		}
		//when you break out of the while loop you are at the second node to last
		cursor.setNext(null); 
	}
	public void deleteNext(LinkedListNode<T> currentNode) /** remove node following currentNode if no node exists do nothing**/
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=head;
		LinkedListNode<T> temp= new LinkedListNode<T>();
		temp=cursor; //we have found 
		
		while(cursor.getNext()!=null)
		{
			cursor=cursor.getNext();
			if(cursor.equals(currentNode))
			{
				temp=cursor;
			}
			if(cursor.getNext()==null)
			{
				//do nothing
			}
			
		}
		temp.setNext(temp.getNext().getNext());
		
	}
	

	public int size() /** return number of nodes in this list**/
	{
		if(head.equals(null)) //this is when the list has no nodes
		{
			return 0;
		}
		int count=1; //when at least the head is not null, we have at least one node so initialize count to 1

		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		while(cursor.getNext()!=null) //when the next one is not null
		{
			cursor=cursor.getNext(); //move it down the list
			count++; //increase our count
		}
		return count; //when we break out of the while loop we have traversed the entire linked list
		//and return count
		
	}
	/**Gives a string representation of this linkedlist**/
	public String toString()
	{
		
		String line=""; //have and empty string
		LinkedListNode<T> cursor= head; //have a cursor node
		
		while(cursor!=null) //when the cursor is not null
		{
			line+= cursor.getData() + "->"; //add the data of the currentNode to the string
			
			
			cursor=cursor.getNext(); //move it to the next node in the list
			
		}
		
		System.out.println(line); 
		return line; //return this string
		
		
	}

	public boolean isEmpty() //checks to see of the list is empty
	{
		if(head==null) //if the head is null, it means that the head is empty
		{
			
			return true; //therefore return true
		}
		
		return false; //else the list is not empty, and we return false
		
	}
	
	
		
		

	
}
