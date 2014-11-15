import java.util.Random;
public class Test{
	public static void main(String[] args) {
		
		Random num = new Random();
		int maximo = 10000;
		Comparable array[];
		array = new Comparable[maximo];
		HeapDyn heap = new HeapDyn(5);
		
		for (int i = 0; i < maximo; i++) {array[i]=num.nextInt()*5;}
		heap.heapSort(array,maximo);
		//for (int i = 0; i < maximo; i++) {System.out.println(array[i]);}

	}
}
