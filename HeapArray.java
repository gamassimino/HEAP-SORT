public class HeapArray implements PriorityQueue{
	
	private static final int MaxQueue = 100;
	private Comparable item[];
	private int lastItem;

	//constructor
	public HeapArray(){
		item = new Comparable[MaxQueue];
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
	public void queue(Comparable element){
		if (lastItem < MaxQueue) {
			item[lastItem] = element;
			lastItem++;
		}
	}

	//method that delete de min element in a queue
	public Comparable dequeue(){
		lastItem--;
		return item[lastItem + 1];
	}

	



}//end of class
