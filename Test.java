import java.util.Random;
public class Test{
	public static void main(String[] args) {
<<<<<<< HEAD
	Random num = new Random();
		int maximo = 10000;
		Comparable[] array = new Comparable[maximo];

		for (int i = 0; i < maximo; i++)
			array[i] = num.nextInt() * 5;
=======
		
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
>>>>>>> 4568f3e66e578524c13736fdc1b9402594cf38f9

		float time_start, time_end;
		time_start = System.currentTimeMillis();

		HeapDyn.heapSort(array,10000);

		time_end = System.currentTimeMillis();

		System.out.println(time_end);
	}
}

//100000 1s quickSort
//1000000 4s treeSort
//999999 1s heapSort

