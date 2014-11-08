public class HeapArray implements PriorityQueues{

	private static final int MaxStack = 100;
	private Comparable item[];
	private int lastItem;

	//constructor
	public QueuesWhithArray(){
		item = new Object[MaxStack];
		lastItem = 0;
	}

	//method that says if a queue is empty
	public boolean isEmpty(){
		return (lastItem == 0);
	}

	//method that make an empty queue
	public void makeEmpty(){
		lastItem = 0;
	}

	//method that insert a new element in a queue
	public void queued(Comparable element){
		item[lastItem] = element;
		lastItem++;
	}

	//method that delete de min element in a queue
	public void dequeue(){
		lastItem--;
	}

	



}//end of class