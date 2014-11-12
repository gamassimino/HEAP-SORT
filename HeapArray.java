public class HeapArray implements PriorityQueue{
	
	private static final int MaxQueue = 100;
	private Comparable item[];
	private int lastItem;

	//constructor
	public HeapArray(){
		item = new Comparable[MaxQueue];
		lastItem = 0;
	}

	public static void swap(Comparable[] array, int i, int j){
	  Comparable temp = array[i];
  	  array[i] = array[j];
	  array[j] = temp;
 	}

/*
REVISAR SI SE PUEDE HACER MAS EFICIENTE CON EL USO DE UNA CONDICION
	public void orderQueue(int pos){
		boolean flag = true;
		while ((pos >= 0)&&(flag)){
			if (pos%2 == 0){
				if (item[pos].compareTo(item[(pos-1)/2]) < 0){
					swap(item, pos, (pos-1)/2);
				}
				else{
					flag = false;
				}
			}
			else{
				if (item[pos].compareTo(item[pos/2]) < 0){
					swap(item, pos, (pos-1)/2);
				}
				else{
					flag = false; 
				}
			}
		pos--;
		}
	}
*/

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
	}

	//=============//
	//(2*i)+1 left //
	//2*(i+1) right//
	//=============//

	public int getMin(Comparable [] array, int i, int j){
		if (array[i].compareTo(array[j]) > 0){
			return j;
		}
		else{
			return i;
		}
	}

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
	}

	//method that says if a queue is empty
	public boolean isEmpty(){
		return (lastItem == 0);
	}

	//method that make an empty queue
	public void makeEmpty(){
		lastItem = 0;
	}

	//method that insert a new element in a queue
	public void queued(Comparable element){
		if (lastItem < MaxQueue) {
			item[lastItem] = element;
			lastItem++;
			orderQueue(lastItem-1);
		}
	}

	//method that delete de min element in a queue
	public Comparable dequeue(){
		int pos = 0;
		Comparable aux = item[pos];
		lastItem--;
		item[0] = item[lastItem];
		orderDequeue();
		return aux;
	}

	public void heapSort(Comparable [] array, int n){
		HeapArray ordArray = new HeapArray();
		System.out.println(ordArray.repOk());
		for (int i = 0; i < n; i++){ ordArray.queued(array[i]);}
		for (int i = 0; i < n; i++){ array[i] = ordArray.dequeue();}
		System.out.println(ordArray.repOk());
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

	
	public static void main(String[] args) {
		Comparable array[];
		array = new Comparable[6];
		array[0] = 2;
		array[1] = 9;
		array[2] = 7;
		array[3] = 3;
		array[4] = 1;
		array[5] = 8;

		HeapArray ordArray = new HeapArray();
		ordArray.heapSort(array, 6);
		for (int i = 0; i < 6; i++){System.out.println(array[i]);}
	}

}//end of class
