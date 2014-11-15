public interface PriorityQueue{

	public abstract boolean isEmpty();

	public abstract void makeEmpty();

	public abstract void queued(Comparable element);

	public abstract Comparable dequeue();

	public abstract boolean repOk();
}
