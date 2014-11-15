public interface PriorityQueue{

	public abstract boolean isEmpty();

	public abstract void makeEmpty();

	public abstract void queued(Comparable element);

	public abstract Comparable dequeue();

	//public static abstract void heapSort(Comparable [] array, int n);

	public abstract boolean repOk();
}