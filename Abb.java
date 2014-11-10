import java.util.*;
public class Tree {

	private Tree hi;
	private Integer element;
	private Tree hd;

	// constructor
	public Tree(Integer ele){
		hi = null;
		hd = null;
		element = ele;
	}

	// constructor 
	public Tree(){
		hi = null;
		hd = null;
		element = null;
	} 

	// return the root
	public Integer getRoot(){
		return element;
	}

   // Setea la raiz
	public void setRoot(Integer item){
		element = item;
	}

   // Dice si el arbol es vacio
 	public boolean isEmpty(){
 		return element == null;
 	}

   //Remueve todo los nodos del arbol
	public void makeEmpty(){
		element = null;
		hi = null;
		hd = null;
	}

   // recorrido preOrder
 	public void printPreOrder(){
 		// se imprime la raiz
 		if(element != null) 
  		System.out.print(element+" ");
    // se recorre el hi
  	if (hi != null){
       hi.printPreOrder();
		}
   	if (hd != null){
       hd.printPreOrder();
		}
 	}

   // recorrido postOrder
 	public void printPostOrder(){
 		// se recorre hi
  	if (hi != null){
      hi.printPostOrder();
		}
  	if (hd != null){
      hd.printPostOrder();
		}
		if(element != null) 
  		System.out.print(element+" ");
 	}

	// find a specific element in the tree 
 	public boolean search(Integer ele){
		if(element == null)
			return  false;
			else{
			if(ele == element){
				return  true;
			}
			else{
				if(ele > element && hd != null){
					return  hd.search(ele);
				}
				else{
					if(ele < element && hi != null){
						return  hi.search(ele);
					}
					else{
						return false;
					}
				}
			}
		}
		//return return;
	}
	 
	 	
	// return de minimun of the tree
 	public Integer min(){
 		if(hi != null && hi.element != null){
 			return hi.min();
 		}
 		else {
	 		return element;
	 	}
	}
// return the max of the tree
 	public Integer max(){
 		if(hd != null && hd.element != null){
 			return hd.max();
 		}
 		return element;
 	}

 //	borrar un elemento
 	public void delete(Integer ele){
 		if(search(ele)){
 			if(element < ele)
 				hd.delete(ele);
 			else{
 				if(ele < element)
 					hi.delete(ele);
 				else{
 					if(element == ele){
 						if (hd != null){
 							Integer min = hd.min();
	 						hd.delete(min);
	 						element = min;
	 					}
	 					else{
	 						if(hi != null){
	 							Integer max = hi.max();
	 							hi.delete(max);
	 							element = max;
	 						}
	 						else{
	 							element = null;
	 						}
	 					}
 					}
 				}
 			}
 		}
 	}

   // recorrido inOrder
 	public void printInOrder(){
 		// se recorre el hi
 			if (hi != null){
    	hi.printInOrder();
		}
		if(element != null) 
			System.out.print(element+" ");
  	// se imprime el hd
 		if (hd != null){
  		hd.printInOrder();
 		}
 	}

 	// inserta un elemento
	public void insert(Integer ele){
		if(isEmpty()){
			element = ele;
			hi = null;
			hd = null;
		}
		else{
			if(element < ele){
				if (hd != null)
					hd.insert(ele);
				else
					hd = new Tree(ele);
			}
			else{
				if(element > ele){
					if (hi != null) 
						hi.insert(ele);
					else{
						hi = new Tree(ele);
					}
				}
			}
		}
	}

	public void treeToLs (LinkedList<Integer> ls){
		// se recorre el hi
 		if (hi != null){
    	hi.treeToLs(ls);
		}
		if(element != null) 
			ls.add(element);
  	// se imprime el h,
  	if (hd != null){
  		hd.treeToLs(ls);
 		}
	}

	public boolean repOk(){
		LinkedList<Integer> ls = new LinkedList<Integer>(	);
		treeToLs(ls);
		Integer i = 0;
		boolean condition = true;
		while(i < (ls.size() - 1) && condition){
			condition = ls.get(i) < ls.get(i+1);
			i++;
		}
		//verificar si la lista esta ordenada pos I < pos I+1 de la lsita 
		return condition;
	}
}