public class QuickSort{

	private static void swap(Comparable[] array, int i, int j){
	  Comparable temp = array[i];
  	  array[i] = array[j];
	  array[j] = temp;
 	}//end swap

	// quickSort: implementa el algoritmo de quicksort
	// pre: 0 <= begin <= end <= array.lenght
	// post: ordena array
	public static void quickSort(Comparable[] array, int begin, int end){
		if (begin < end){
			// Calculo la particion 
			int p = partition(array, begin, end);
			// ordeno la parte izq
			quickSort(array, begin, p);
			// ordeno la parte derecha
			quickSort(array, p+1, end);
		}
	}	
	
	// partition: dado un arreglo retorna un p, el cual es el pivote.
	// pre: 0 <= begin <= end <= array.lenght
	// post: para todo begin <= k <= p: array[k] <= array[p] y para todo k: p <= k <= end : array[p] <= array[k]
	public static int partition(Comparable[] array, int begin, int end){
		Comparable pivot = array[begin];
		int i = begin - 1;
		int j = end + 1;
		while (i < j) {
			//invariante: 
			//para k < = i : a[k] <= pivot y para k >= j : pivot <= a[k] 
			do j--; while (array[j].compareTo(pivot) > 0); 
			do i++; while (array[i].compareTo(pivot) < 0);
			if (i < j){
				swap(array, i, j);
			}	
		}
		return j;
	}

}