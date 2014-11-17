import java.util.Random;
public class Test{
	public static void main(String[] args) {
		
		Random num = new Random();
		int maximo = 1000001;
		Comparable array[];
		array = new Comparable[maximo];

		long TInicio, TFin, tiempo; //variables para controlar el timepo
		
		//================================HEAP-ARRAY================================
		//for (int i = 0; i < maximo; i++){array[i]=num.nextInt()*999999;}
		//TInicio = System.currentTimeMillis();
		//HeapArray.heapSort(array,10);
		//TFin = System.currentTimeMillis();
		//tiempo = TFin - TInicio;
		//for (int i = 0; i < 10; i++) {System.out.println(array[i]);}
		//System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
		//================================HEAP-ARRAY================================


		//================================HEAP-DYN================================
		//for (int i = 0; i < maximo; i++){array[i]=num.nextInt()*999999;}
		//TInicio = System.currentTimeMillis();
		//HeapDyn.heapSort(array,1000000);
		//TFin = System.currentTimeMillis();
		//tiempo = TFin - TInicio;
		//for (int i = 0; i < 1000000; i++) {System.out.println(array[i]);}
		//System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
		//================================HEAP-DYN================================


		//================================TREE-SORT================================
		//for (int i = 0; i < maximo; i++){array[i]=num.nextInt()*999999;}
		//TInicio = System.currentTimeMillis();
		//Abb.treeSort(array,10);
		//TFin = System.currentTimeMillis();
		//tiempo = TFin - TInicio;
		//for (int i = 0; i < 10; i++) {System.out.println(array[i]);}
		//System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
		//================================TREE-SORT================================

		//================================QUICK-SORT================================
		//for (int i = 0; i < maximo; i++){array[i]=num.nextInt()*999999;}
		//TInicio = System.currentTimeMillis();
		//QuickSort.quickSort(array,0,1000000);
		//TFin = System.currentTimeMillis();
		//tiempo = TFin - TInicio;
		//for (int i = 0; i < 1000000; i++) {System.out.println(array[i]);}
		//System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
		//================================QUICK-SORT================================

	}
}


