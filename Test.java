import java.util.Random;
public class Test{
	public static void main(String[] args) {
		
		Random num = new Random();
		int maximo = 1000001;
		Comparable array[];
		array = new Comparable[maximo];
		Comparable arrray[];
		arrray = new Comparable[maximo];
		
		for (int i = 0; i < maximo; i++){
			array[i]=num.nextInt()*5;
			arrray[i]=array[i];
		}

		System.out.println(" ");
		System.out.println(" HEAPSORT ");
		System.out.println(" ");
		HeapArray heap = new HeapArray();
		heap.heapSort(array,1000000);
		for (int i = 0; i < 1000000; i++) {System.out.println(array[i]);}

		System.out.println(" ");
		System.out.println(" TREESORT ");
		System.out.println(" ");
		Abb tree = new Abb();
		tree.treeSort(arrray,1000000);
		for (int i = 0; i < 1000000; i++) {System.out.println(arrray[i]);}



	}
}

//1000000 1s quickSort
//1000000 4s treeSort
//1000000 1s heapSort array

