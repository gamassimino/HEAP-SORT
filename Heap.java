public class Heap{

	private Comparable root;
	private Heap left;
	private Heap right;

	//constructors
	//===================================
	public Heap(){
		root = null;
		left = null;
		right = null;
	}

	public Heap(Comparable element){
		root = element;
		left = null;
		right = null;
	}
	//====================================

	public void swap(Comparable element){
		Comparable aux = element;
		element = this.root;
		this.root = aux;
	}

	public void insert(Comparable element){
		if (root == null){
			root = element;
		}
		else{
			if (left != null){
				if (right == null){
					right = new Heap(element);
					if ((right.root).compareTo(element) < 0){
						this.swap(right.root);
					}//end of if
				}//end of if
			}
			if (left == null){
				left = new Heap(element);
				if ((left.root).compareTo(element) < 0){
					this.swap(left.root);
				}//end of if
			}//end of if
			if ((left != null) && (right != null)){
				(left.left) = new Heap(element);
			}//end of if
		}//end of if-else
	}//end of insert

	

	public void delete(Comparable root){
		if (left == null){
			this.root = null;
		}//end of if
		if (right != null){
			right.delete(root);
		}//end of if
		if (right == null){
			if (left != null){
				root = left.root;
				left = null;
			}
			else{
				root = this.root;
				this.root = null;
			}
		}//end of if-else
		if (left != null){
			left.delete(root);
		}//end of if
	}//end of delete

	public void printInOrder(){
 		// se recorre el hi
 			if (left != null){
    	left.printInOrder();
		}
		if(root != null) 
			System.out.print(root+" ");
  	// se imprime el hd
 		if (right != null){
  		right.printInOrder();
 		}
 	}

 public static void main(String[] args) {
 	Heap heap = new Heap();
 	heap.insert(2);
 	heap.insert(1);
	//heap.insert(6);
 	//heap.insert(7);
 	//heap.insert(9);
 	heap.printInOrder();
 }

}//end of class