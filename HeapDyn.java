public class HeapDyn{

	private Comparable root;
	private HeapDyn left;
	private HeapDyn right;

	//constructor
	public HeapDyn(){
		root = null;
		left = null;
		right = null;
	}
/*
intercambia los valores se usa para patear el valor insertado para arriba
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
		if((left == null && right == null) || (left != null && right != null))
			cond = left.balance() && right.balance();
		else
			cond = false;
		return cond;

	}
/*
inserta un elemento el heap
--- falta ahcer que inserte donde valla y luego lo ordene en su lugar---
*/
	public void insert(Comparable element){
		if (root == null){
			root = element;
		}
		else{
			if (left == null){
				left.root = element;
				if ((left.root).compareTo(element) > 0){
					this.swap(left.root);
				}//end of if
			}//end of if
			if (right == null){
				right.root = element;
				if ((right.root).compareTo(element) > 0){
					this.swap(right.root);
				}//end of if
			}//end of if
			if ((left != null) && (right != null)){
				left.insert(element);
			}//end of if
		}//end of if-else
	}//end of insert

	
/*
	public void delete(){
		Heap aux = root;
		if (right != null){
			right.delete();
		}
		if (right == null){
			aux = root;
			root = null;
		}
	}//end of delete
*/
}//end of class