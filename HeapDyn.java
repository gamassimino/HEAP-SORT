//import java.lang.*;
public class HeapDyn implements PriorityQueue{

	private Comparable root;
	private HeapDyn left;
	private HeapDyn right;

	//constructor
	public HeapDyn(){
		root = null;
		left = null;
		right = null;
	}
	public HeapDyn(Comparable ele){
		root = ele;
		left = null;
		right = null;
	}


	public boolean isEmpty(){
		return root == null;
	}

	public void makeEmpty(){
		root = null;
		left = null;
		right = null;
	}
/*
intercambia los valores se usa para patear el valor insertado para arriba
por si cuando se inserta queda desordenado el heap
*/
	public void swap(Comparable element){
		Comparable aux = element;
		element = this.root;
		this.root = aux;
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
/*me da la altura de un heap*/
	public int alt(){
		if (left != null && right != null){
			return 1 + Math.max(left.alt(),right.alt());
		}
		else{
			if (left != null)
				return 1 + left.alt();
			else{
				if (right != null)
				return 1 + right.alt();
			else 
				return 0;
			}
		}
	}

/*
inserta un elemento el heap
--- falta hacer que lo ordene en su lugar---
*/
	public void queued(Comparable element){
		/*pregunta si ela rbol esta vacio*/
		if (root == null){
			root = element;
		}
		else{
			/*si el izq = null por lo tanto no tiene hijos*/
			if (left == null){
				left = new HeapDyn(element);
				//order(left.root);
			}//end of if
			else{	
				/*pregunta si el derecho es nul asumiendo que el izquierdo tiene algo ya que llego 
				hasta esta instancia*/
				if (right == null){
					right = new HeapDyn(element);
					//order(left.root);
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
							pasar que el izq sea el de mayor alt por lo tanto se lo inserta en el derecho
							o puede pasar que los dos sean de altura iguales cosa de que los dos este completo 
							entonces se comienza por el hijo izq*/
							if(left.alt()<= right.alt()){//si ambos estan balanceado se pone en el izq
								left.queued(element);
							}
							else{//este se podria omitir porque si ambos estan balanceados entraria por el primero
								right.queued(element);
							}
						}
					}
				}
			}	
		}
	}

	//public void 
	/*
	Falta hacer el metodo que ordena el heap una vez que se inserto o se elimino un elemento
	y falta ahcer el eliminar el cual devuelve la raiz del heap y en el lugar de la raiz poone
	el ultimo elemento del heap que esta mas a la derecha
	*/

	public Comparable dequeue(){
		return 1;
		/*Heap aux = root;
		if (right != null){
			right.dequeue();
		}
		if (right == null){
			aux = root;
			root = null;
		}
		*/
	}//end of dequeue

}//end of class