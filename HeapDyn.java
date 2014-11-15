public class HeapDyn implements PriorityQueue{

	private Comparable root;
	private HeapDyn dad;
	private HeapDyn left;
	private HeapDyn right;


	/*
	genera un heap con una raiz
	*/
	public HeapDyn(Comparable ele){
		dad = null;
		root = ele;
		left = null;
		right = null;
	}

	/*
	genera un heap con la raiz y el padre de ese nodo
	*/
	public HeapDyn(Comparable ele,HeapDyn dady){
		dad = dady;
		root = ele;
		left = null;
		right = null;
	}

	/*
	devuelve true si el hep esta vacio
	*/
	public boolean isEmpty(){
		return root == null;
	}

	/*
	me inicializa la cola
	*/
	public void makeEmpty(){
		dad = null;
		root = null;
		left = null;
		right = null;
	}

	/*
	retorna TRUE si el heap esta balanceado
	retorna FALSE si el hep no lo esta
	balanceado altMinima(left) == altMinima(right)
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

	/*
	retorna la altura minima de un arbol, esta orientada al uso que le damos en
	los metodos de esta clase por eso puede tener variaciones pero la idea es
	
	altMin :: heap -> int
	null = 0
	node(left x right) = 1 + min(altMin(left), altMin(right))
	*/
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

	/*
	retorna la altura maxima de un arbol, esta orientada al uso que le damos en 
	los metodos de esta clase or eso puede tener variaciones pero la idea es
	
	altMax :: heap -> int
	null = 0
	node(left x right) = 1 + max(altMax(left), altMax(right))
	*/
	public int altMax(){
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
		}
	}

	/*
	inserta un nuevo elemento en el heap en el brazo mas a la derecha que este vacio
	si el nivel esta completo comienza insertando en el siguiente nivel lo mas a la 
	izquierda y luego lo va patiando hacia arriba si este es menor que el padre 
	y asi sucesivamente
	*/
	public void queued(Comparable element){
		/*si el izq esta vacio entoces o inserta en el izq si no, quiere decir que el
		vacio es el brazo derecho*/
		if (left == null){
			HeapDyn aux = this;
			left = new HeapDyn(element,aux);
			left.orderQueue();
		}
		else{	
			if (right == null){
				HeapDyn aux = this;
				right = new HeapDyn(element,aux);
				right.orderQueue();
			}
			else{/*si llega hasta aca queire decir que izq e der tenian algo lo que nos indica que no es
				el ultimo nivel del arbol*/
				if (left.balance() && ! right.balance()){/*si der esta desbalanciado entonces va a ese brazo*/
					right.queued(element);
				}
				else{
					if (!left.balance() && right.balance()){/*si izq no esta balanceado se va a ese brazo*/
						left.queued(element);
					}
					else{
						/*si llego hasta esta instancia es porque los dos brazos estan balanciado pero puede
						pasar que el izq sea el de mayor altMin por lo tanto se lo inserta en el derecho
						o puede pasar que los dos sean de altMinura iguales cosa de que los dos este completo 
						entonces se comienza por el hijo izq*/
						if(left.altMin()<= right.altMin()){/*si ambos estan balanceado se pone en el izq*/
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

	
	/*
	ordena los elementos una ves que se inserto, lo patea hacia arriba hasta encontrar su lugar
	*/
	public void orderQueue(){
		boolean cond = false;
		if(dad != null){
			if (root.compareTo(dad.root) < 0) {
				cond = true;
				Comparable aux = root;
				root = dad.root; 
				dad.root = aux;
				if(cond)
					dad.orderQueue();
			}	
		}
	}
	/*
	ordena los elementos una ves que se elimino, compara con el minimo de sus dos hijos y lo intercambia 
	por el menor de los dos y asi sucesivamente hasta hallar su posicion
	*/
	public void orderDequeue(){
		boolean cond = false;
		if (left != null && right != null){
			if ((left.root).compareTo(right.root) < 0){
				if ((left.root).compareTo(root) < 0){
					cond = true;
					Comparable aux = root;
					root = left.root;
					left.root = aux;
				}
				if(cond)
					left.orderDequeue();
			}
			else{
				if ((right.root).compareTo(root) < 0){
					cond = true;
					Comparable aux = root;
					root = right.root;
					right.root = aux;
				}
				if(cond)
					right.orderDequeue();
			}

		}
		else{
			if(left != null){
				if ((left.root).compareTo(root) < 0){
					cond = true;
					Comparable aux = root;
					root = left.root;
					left.root = aux;
				}
				if(cond)
					left.orderDequeue();
			}
		}
	}

	/*
	retorna la hoja ultima mas a la derecha	
	*/
 	public Comparable searchLeaf(){
 		/*
		si la altura = 0 por nuestro altMax quiere decir que tiene un solo elemento
		entonces lo retorna y setea esa posicion en null
		*/
 		if (altMax() == 0){
 			Comparable aux = root;
 			root = null;
 			return aux;
 		}
 		/*
		como la altura es mayor a uno quiere decir que tiene elementos
		*/
 		if (altMax() > 1){
 			if (left.altMax() > right.altMax())
 				return left.searchLeaf();
 			else
 				return right.searchLeaf();
 		}
 		else{
 			/*
			si no esta balanciado entonces el que busco es el de la izquierda ya que no puede
			tener algo el der y estar vacio el iz
			*/
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
 	}

	/*
	eliminar el elemento y ordena al mismo tiempo
	*/
	public Comparable dequeue(){
		Comparable aux = root;
		root = searchLeaf();
		orderDequeue();
		return aux;
	}

	/*
	HeapSort, saca todos los elementos del arreglo lo inserta e un heap y luego saca
	uno por uno y lo vuelve a insertar en ela rreglo
	*/
	public static void heapSort(Comparable [] array, int n){
		HeapDyn heap = new HeapDyn(array[0]);
		for (int i = 1; i < n; i++) {
			heap.queued(array[i]);
		}
		for (int i = 0; i < n; i++) {
			array[i] = heap.dequeue();
		}
	}
}
