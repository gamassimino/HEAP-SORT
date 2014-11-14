public class HeapArray implements PriorityQueue{
	
	private static final int MaxQueue = 100;
	private Comparable item[];
	private int lastItem;

	//Constructor
	public HeapArray(){
		item = new Comparable[MaxQueue];
		lastItem = 0;
	}
	//Intercambia dos elementos
	public static void swap(Comparable[] array, int i, int j){
	  Comparable temp = array[i];
  	  array[i] = array[j];
	  array[j] = temp;
 	}

	//Ordena los elementos (utilizado luego de insertar uno nuevo)
	public void orderQueue(int pos){
		while (pos >= 0){
			if (pos%2 == 0){
				if (item[pos].compareTo(item[(pos-1)/2]) < 0){
					swap(item, pos, (pos-1)/2);
				}
			}
			else{
				if (item[pos].compareTo(item[pos/2]) < 0){
					swap(item, pos, (pos-1)/2);
				}
			}
		pos--;
		}
	}//Fin orederQueue

	//Retorna el minimo
	public int getMin(Comparable [] array, int i, int j){
		if (array[i].compareTo(array[j]) > 0){
			return j;
		}
		else{
			return i;
		}
	}
	//Ordena los elementos (utilizado luego de eliminar uno)
	public void orderDequeue(){
		int i = 0;
		while (2*i+1 <= lastItem || 2*(i+1) <= lastItem){
			int j = i;
			int hi = 0;
			int hd = 0;
			if(((2*i)+1) <= lastItem){
				hi = 2*i+1;
			}
			if (2*(i+1) <= lastItem){
				hd = 2*(i+1);
			}
			if(hd == 0)
				i = hi;
			else 
				i = getMin(item,hi,hd);
			if (item[j].compareTo(item[i]) > 0){
				Comparable aux = item[j];
				item[j] = item[i];
				item[i] = aux;
			}
		}
	}//Fin orderDequeue

	//Dice si la cola es vacia
	public boolean isEmpty(){
		return (lastItem == 0);
	}

	//Vacia la cola
	public void makeEmpty(){
		lastItem = 0;
	}

	//Inserta un nuevo elemento en la cola
	public void queued(Comparable element){
		if (lastItem < MaxQueue) {
			item[lastItem] = element;
			lastItem++;
			orderQueue(lastItem-1);
		}
	}

	//Elimina el minimo elemento de la cola
	public Comparable dequeue(){
		int pos = 0;
		Comparable aux = item[pos];
		lastItem--;
		item[0] = item[lastItem];
		orderDequeue();
		return aux;
	}

	//Metodo de ordenamiento 
	public void heapSort(Comparable [] array, int n){
		HeapArray ordArray = new HeapArray();
		for (int i = 0; i < n; i++){ ordArray.queued(array[i]);}
		for (int i = 0; i < n; i++){ array[i] = ordArray.dequeue();}
	}
	
	public boolean repOk(){
		boolean flag = true;
		for (int i=0; i<lastItem; i++){
			if (item[(2*i)+1] != null) {flag = flag && (item[i].compareTo(item[(2*i)+1]) < 0);}
			if (item[2*(i+1)] != null) {flag = flag && (item[i].compareTo(item[2*(i+1)]) < 0);}
			if (item[(2*i)+1] == null) {flag = flag && (item[2*(i+1)] == null);}
		}
		return flag;
	}
}//Fin HeapArray
