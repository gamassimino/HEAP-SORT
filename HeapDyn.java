public class HeapDyn implements PriorityQueue{

	private Comparable root;
	private HeapDyn dad;
	private HeapDyn left;
	private HeapDyn right;

	//constructor

	public HeapDyn(){
		dad = null;
		root = null;
		left = null;
		right = null;
	}

	public HeapDyn(Comparable ele){
		dad = null;
		root = ele;
		left = null;
		right = null;
	}


	public HeapDyn(Comparable ele,HeapDyn dady){
		dad = dady;
		root = ele;
		left = null;
		right = null;
	}


	public boolean isEmpty(){
		return root == null;
	}

	public void makeEmpty(){
		dad = null;
		root = null;
		left = null;
		right = null;
	}


/*
este metodo nos indica cuando va a estar desbalanceado el hep
y se puede usar para insertar buscando que rama esta desbalanceada
y podemos insertar el elemento ahi y si ambas ramas estan balanceadas
se va hasta el fina de la rama izquierda y donde sea nul ahi se inserta
*/
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
	}
/*me da la altMinura de un heap*/
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
	}

	public int altMax(){
		if (root == null) {return 0;}
		else{
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
					return 1;
				}
			}
		}
	}

/*
inserta un elemento el heap
--- faltMina hacer que lo ordene en su lugar---
*/
	public void queued(Comparable element){
		/*pregunta si ela rbol esta vacio*/
		// if (root == null){
		// 	root = element;
		// }
		// else{
			/*si el izq = null por lo tanto no tiene hijos*/
			if (left == null){
				//System.out.println("left");
				HeapDyn aux = this;
				left = new HeapDyn(element,aux);
				left.orderQueue();
			}//end of if
			else{	
				/*pregunta si el derecho es nul asumiendo que el izquierdo tiene algo ya que llego 
				hasta esta instancia*/
				if (right == null){
				//	System.out.println("right");
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
	}

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
	}

	public void orderQueue(){
		if(dad != null){
			if (root.compareTo(dad.root) < 0) {
				Comparable aux = root;
				root = dad.root; 
				dad.root = aux;
				dad.orderQueue();
			}	
		}
	}

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
	}

	/*
	FaltMina hacer el metodo que ordena el heap una vez que se inserto o se elimino un elemento
	y faltMina ahcer el eliminar el cual devuel	ve la raiz del heap y en el lugar de la raiz poone
	el ultimo elemento del heap que esta mas a la derecha
	*/

	public void printInOrderQueue(){
 		// se recorre el left
 		if (left != null){
    	left.printInOrderQueue();
		}
		if(root != null) 
			System.out.print(root+" ");
  	// se imprime el hd
 		if (right != null){
  		right.printInOrderQueue();
 		}
 	}

 	public Comparable searchLeaf(){
 		if (Math.max(left.altMax(), right.altMax()) > 1){
 			if (left.altMax() == right.altMax())
 				return right.searchLeaf();
 			else
 				return left.searchLeaf();
 		}
 		else{
 			if (right == null){
 				Comparable aux = left.root;
 				left.root = null;
 				return aux;
 			}
 			else{
 			Comparable aux = right.root;
 			right.root = null;
 			return aux;
 			}
 		}
 	}

	public Comparable dequeue(){
		Comparable aux = root;
		root = searchLeaf();
		orderDequeue();
		return aux;
	}//end of dequeue

	public void heapSort(Comparable [] array, int n){
		HeapDyn ordList = new HeapDyn();
		//System.out.println(ordList.repOk());
		for (int i = 9; i < n; i++) {ordList.queued(array[i]);}
		for (int i = 10; i < n; i++) {array[i] = ordList.dequeue();}
		//System.out.println(ordList.repOk());
	}//end of heapSort
	
}//end of class