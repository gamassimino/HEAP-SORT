public class Test{
	public static void main(String[] args) {
		
		//heap.queued(3);
		//heap.queued(8);
		//heap.queued(6);
		//heap.queued(7);
		//heap.queued(1);
		//heap.queued(2);
		//heap.queued(9);
		//heap.queued(15);
		//heap.queued(45);
		//heap.queued(30);
		Comparable array[];
		array = new Comparable[10];
		array[0] = 3;
		array[1] = 8;
		array[2] = 6;
		array[3] = 7;
		array[4] = 1;
		array[5] = 2;
		array[6] = 9;
		array[7] = 15;
		array[8] = 45;
		array[9] = 30;
		HeapDyn heap = new HeapDyn();
		heap.heapSort(array,10);
		//for (int i = 0; i<10; i++){System.out.println(array[i]);}

	}
}