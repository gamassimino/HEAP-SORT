public class TreeSort{

	private Integer root;
	private BinaryTree left;
	private BinaryTree right;

	public TreeSort tree;

	//constructor por defecto
	public BinaryTree(){
		root = null;
		left = null;
		right = null;
	}

	//constructor con valor para la raiz
	public BinaryTree(Integer root){
		this.root = root;
		left = null;
		right = null;
	}

	//da a conocer si el arbol es vacio 
	public boolean isEmpty(){
		return (root == null);
	}

	//destruye o vacia el arbol
	public void makeEmpey(){
		root = null;
	}
	
	//inserta un elemento en el arbol y no considera repetidos
	public void insert(Integer root){
		if (this.root == null){
			this.root = root;
		}
		else{
			if (this.root > root){
				if (left != null){
					left.insert(root);
				}
				else{
					this.left = new BinaryTree(root); 
				}//end of if-else
			}
			else{
				if (right != null){
					right.insert(root);
				}
				else{ 
					this.right = new BinaryTree(root);
				}//end of if-else
			}//end of if-else
		}//end of if-else
	}//end of insert

	public boolean search(Integer root){
		if (this.root == null){
			return false;
		}
		else{
			if (this.root == root){
				return true;
			}
			else{
				if (this.root > root){
					if (this.left == null){
						return false;
					}
					else{
						return left.search(root);
					}//end of if-else
				}
				else{
					if (this.right == null){
						return false;
					}
					else{
						return right.search(root);
					}//end of if-else
				}//end of if-else
			}//end of if-else
		}//end of if-else
	}//end of search

	public Integer maximum(){
		if (right == null){
			return root;
		}
		else{
			return right.maximum();
		}//end of if-else
	}//end of maximum

	public Integer minimum(){
		if (left == null){
			return root;
		}
		else{
			return left.minimum();
		}//end of if-else
	}//end of minimum

	public void delete(Integer root){
		if ((tree.isEmpty() == false) && (tree.search(root) == true)){
			if (this.root == root){
				if ((this.left == null) && (this.right == null)){
					this.root = null;
				}
				else{
					if (this.left == null){
						this.root = right.getRoot();
					}//end of if
					if (this.right == null){
						this.root = left.getRoot();
					}//end of if

				}//end of if-else
			}
			else{
				if (this.root > root){
					left.delete(root);
				}//end of if
				if (this.root < root){
					right.delete(root);
				}//end of if
			}//end of if-else
		}//end of if
	}//end of delete

	public TreeList makeList(){

		TreeList pointer = new TreeList();

		if (left != null){
			left.makeList();
		}//end of if
		pointer.insert(root);
		if (right != null){
			right.makeList();
		}//end of if
		return pointer;
	}//end of makeList

	public boolean isABB(){

		TreeList pointer = makeList();
		boolean flag = true;
		Integer now = pointer.element; 

		while (pointer.next != null){
			pointer = pointer.next;
			if (pointer.element < now){
				flag = false;
			}//end of if
		}//end of while
		return flag;
	}//end of isABB	

}//end of class