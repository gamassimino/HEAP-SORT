public class HeapDyn implements PriorityQueue{

	private Comparable root;
	private HeapDyn dad;
	private HeapDyn left;
	private HeapDyn right;


	//Constructor
	public HeapDyn(Comparable ele){
		dad = null;
		root = ele;
		left = null;
		right = null;
	}
	//Constructor
	public HeapDyn(Comparable ele,HeapDyn dady){
		dad = dady;
		root = ele;
		left = null;
		right = null;
	}
	//Dice si la cola es vacia
	public boolean isEmpty(){
		return root == null;
	}
	//Vacia la cola
	public void makeEmpty(){
		dad = null;
		root = null;
		left = null;
		right = null;
	}

	//Dice si el Heap esta balanceado
	public boolean balance(){
		boolean cond = true;
		if((left == null && right == null) ){
			cond = true;
		}
		else{
			if (left != null && right != null){
				cond = left.balance() && right.balance();
			}
			else {
				cond = false;
			}
		}
		return cond;
	}//Fin balance
	//Retorna la altura minima de un Heap
	public int altMin(){
		if (left != null && right != null){
			return 1 + Math.min(left.altMin(),right.altMin());
		}
		else{
			if (left != null)
				return 1 + left.altMin();
			else{
				if (right != null)
				return 1 + right.altMin();
			else 
				return 0;
			}
		}
	}//Fin altMin




	//Retorna la altura maxima de un Heap
	public int altMax(){
		// if (root == null) {
		// 	return 0;
		// }
		// else{
			if (left != null && right != null){
				return 1 + Math.max(left.altMax(),right.altMax());
			}
			else{
				if (left != null)
					return 1 + left.altMax();
				else{
					if (right != null)
					return 1 + right.altMax();
				else 
					return 0;
				}
			//}
		}
	}//Fin altMax

	//Inserta un elemento en el heap(Falta hacer que lo haga de forma ordenada)
	public void queued(Comparable element){
		if (left == null){
			HeapDyn aux = this;
			left = new HeapDyn(element,aux);
			left.orderQueue();
		}
		else{	
			/*pregunta si el derecho es nul asumiendo que el izquierdo tiene algo ya que llego 
			hasta esta instancia*/
			if (right == null){
				HeapDyn aux = this;
				right = new HeapDyn(element,aux);
				right.orderQueue();
			}//end of if
			else{/*si llego aca es porquetanto el hijo izq como hijo der son != null
					por lo tanto pregunta si el izquiero esta balanciado y el derecho no
					presumiendo que izq esta lleno y el der no*/
				if (left.balance() && ! right.balance()){//si der no esta blanceado se pone ahi
					right.queued(element);
				}
				else{
					/*si se llego aca es porque el que estaba desbalanciado era el arbol izq entonces se hace
						recursion sonbre el arbol izque ya que es el desbalanciado*/
					if (!left.balance() && right.balance()){//si izq no esta balanceado se pone ahi
							left.queued(element);
					}
					else{
						/*si llego hasta esta instancia es porque los dos arboles estan balanciado pero puede
						pasar que el izq sea el de mayor altMin por lo tanto se lo inserta en el derecho
						o puede pasar que los dos sean de altMinura iguales cosa de que los dos este completo 
						entonces se comienza por el hijo izq*/
						if(left.altMin()<= right.altMin()){//si ambos estan balanceado se pone en el izq
								/*creo que esto andaria mejor si al utilizar la altMinura
								utilizariamos la altMinura menor de cada rama*/
							left.queued(element);
						}
						else{
							right.queued(element);
						}
					}
				}
			}
		}	
	}//Fin queued

	public boolean repOk(){
		boolean cond = true;
		if (left != null && right != null){
			if(root.compareTo(right.root) <= 0 && root.compareTo(left.root) <= 0)
				cond = left.repOk() && right.repOk();
			else
				cond = false;
		}
		else{
			if (left != null ){
				if(root.compareTo(left.root) <= 0)
					System.out.println(root);
				else
					cond = false;
			}
			else{
				if (right != null){
					if(root.compareTo(right.root) <= 0)
						cond = right.repOk();
					else
						cond = false;
				}
			}
		}
		return cond;
	}//Fin repOk
	//Ordena los elementos (utilizada luego de insertar uno nuevo)
	public void orderQueue(){
		if(dad != null){
			if (root.compareTo(dad.root) < 0) {
				 //System.out.println("raiz = "+root);
				Comparable aux = root;
				root = dad.root; 
				dad.root = aux;
				dad.orderQueue();
			}	
		}
	}
	//Ordena los elementos (utilizada luego de eliminar un elemento)
	public void orderDequeue(){
		if (left != null && right != null){
			if ((left.root).compareTo(right.root) < 0){
				if ((left.root).compareTo(root) < 0){
					Comparable aux = root;
					root = left.root;
					left.root = aux;
				}
				left.orderDequeue();
			}
			else{
				if ((right.root).compareTo(root) < 0){
					Comparable aux = root;
					root = right.root;
					right.root = aux;
				}
				right.orderDequeue();
			}
		}
		else{
			if (left != null){
				if ((left.root).compareTo(right.root) < 0){
					if ((left.root).compareTo(root) < 0){
						Comparable aux = root;
						root = left.root;
						left.root = aux;
					}
					left.orderDequeue();
				}
			}
			else{
				if(right != null){
					if ((right.root).compareTo(root) < 0){
						Comparable aux = root;
						root = right.root;
						right.root = aux;
					}
					right.orderDequeue();
				}
			}
		}
	}//Fin orderDequeue

	//Retorna la hoja del ultimo nivel y mas a la derecha
 	public Comparable searchLeaf(){
 		if (altMax() == 0){
 			Comparable aux = root;
 			root = null;
 			return aux;
 		}
 		if (altMax() > 1){
 			if (left.altMax() > right.altMax())
 				return left.searchLeaf();
 			else
 				return right.searchLeaf();
 		}
 		else{
 			if (!balance()){
 				Comparable aux = left.root;
 				left = null;
 				
 				return aux;
 			}
			else{
				Comparable aux = right.root;
				right = null;
 				return aux;
 			}
 		}
 	}//Fin searchLeaf



	public void printInOrderQueue(){
 		//Se recorre el hi
 		if (left != null){
    		left.printInOrderQueue();
		}
		//Se imprime la raiz
		if(root != null) 
			System.out.print(root+" ");
  		//Se recorre el hd
 		if (right != null){
  			right.printInOrderQueue();
 		}
 	}//Fin printInOrderQueue


	//Elimina un elemento de la cola
	public Comparable dequeue(){
		Comparable aux = root;
		System.out.println(root);
		root = searchLeaf();
		orderDequeue();
		return aux;
	}
	//Metodo de ordenamiento
	public static void heapSort(Comparable [] array, int n){
		HeapDyn heap = new HeapDyn(array[0]);
		for (int i = 1; i < n; i++) {
			heap.queued(array[i]);
		}
		
		heap.printInOrderQueue();
		System.out.println();

		for (int i = 0; i < n; i++) {

			array[i] = heap.dequeue();

			heap.printInOrderQueue();
			System.out.println();
		}
	}//Fin heapSort
	
}//Fin HeapDyn
