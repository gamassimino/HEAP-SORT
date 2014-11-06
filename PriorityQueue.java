public interface PriorityQueue <T>{

	abstract public boolean isEmpty();

	abstract public void makeEmpty();

	abstract public void queued(T element);

	abstract public void dequeue(); //or get min
}