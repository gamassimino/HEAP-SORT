public class Heap{

	private Comparable root;
	private Heap left;
	private Heap right;

	//constructor
	public Heap(){
		root = null;
		left = null;
		right = null;
	}

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