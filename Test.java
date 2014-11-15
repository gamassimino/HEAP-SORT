import java.util.Random;
public class Test{
	public static void main(String[] args) {
		
		Random num = new Random();
		int maximo = 1000000;
		Comparable array[];
		array = new Comparable[maximo];
		Abb heap = new Abb();
		
		for (int i = 0; i < maximo; i++) {array[i]=num.nextInt()*5;}
		//heap.convert(array,maximo);
		//for (int i = 0; i < maximo; i++) {System.out.println(array[i]);}

		//array[0]=3;
		//array[1]=1;
		//array[2]=2;
		QuickSort.quickSort(array,0,999999);
		for (int i = 0; i < 999999; i++) {System.out.println(array[i]);}

	}
}

//100000 1s quickSort
//1000000 4s treeSort
//999999 1s heapSort

