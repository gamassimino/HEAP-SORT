public class Test{
	public static void main(String[] args) {
		HeapDyn heap = new HeapDyn(5);
		heap.queued(3);
		System.out.println("inserto 3");
		heap.queued(8);
		System.out.println("inserto 8");
		heap.queued(6);
		System.out.println("inserto 6");
		heap.queued(7);
		System.out.println("inserto 7");
		heap.queued(1);
		System.out.println("inserto 1");
		heap.queued(2);
		System.out.println("inserto 2");
		heap.queued(9);
		System.out.println("inserto 9");
		System.out.println(heap.balance());

			heap.queued(15);
		System.out.println("inserto 15");
		System.out.println(heap.balance());

			heap.queued(45);
		System.out.println("inserto 45");
		System.out.println(heap.balance());

			heap.queued(30);
		System.out.println("inserto 30");
		System.out.println(heap.balance());

	}
}