public interface PriorityQueue{

	abstract public boolean isEmpty();

	abstract public void makeEmpty();

	abstract public void queued(Comparable element);

	abstract public void dequeue(); //or get min
}