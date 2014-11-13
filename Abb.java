import java.util.*;
public class Abb {

	private Abb hi;
	private Comparable element;
	private Abb hd;

	// constructor
	public Abb(Comparable ele){
		hi = null;
		hd = null;
		element = ele;
	}

	// constructor 
	public Abb(){
		hi = null;
		hd = null;
		element = null;
	} 

	// return the root
	public Comparable getRoot(){
		return element;
	}

   // Setea la raiz
	public void setRoot(Comparable item){
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

	// find a specific element in the Abb 
 	public boolean search(Comparable ele){
		if(element == null)
			return  false;
			else{
			if(ele == element){
				return  true;
			}
			else{
				if((ele.compareTo(element) > 0) && hd != null){
					return  hd.search(ele);
				}
				else{
					if((ele.compareTo(element) < 0) && hi != null){
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
	 
	 	
	// return de minimun of the Abb
 	public Comparable min(){
 		if(hi != null && hi.element != null){
 			return hi.min();
 		}
 		else {
	 		return element;
	 	}
	}
// return the max of the Abb
 	public Comparable max(){
 		if(hd != null && hd.element != null){
 			return hd.max();
 		}
 		return element;
 	}

 //	borrar un elemento
 	public void delete(Comparable ele){
 		if(search(ele)){
 			if(element.compareTo(ele) < 0)
 				hd.delete(ele);
 			else{
 				if(ele.compareTo(element) < 0)
 					hi.delete(ele);
 				else{
 					if(element == ele){
 						if (hd != null){
 							Comparable min = hd.min();
	 						hd.delete(min);
	 						element = min;
	 					}
	 					else{
	 						if(hi != null){
	 							Comparable max = hi.max();
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
	public void insert(Comparable ele){
		if(isEmpty()){
			element = ele;
			hi = null;
			hd = null;
		}
		else{
			if(element.compareTo(ele) < 0){
				if (hd != null)
					hd.insert(ele);
				else
					hd = new Abb(ele);
			}
			else{
				if(element.compareTo(ele) > 0){
					if (hi != null) 
						hi.insert(ele);
					else{
						hi = new Abb(ele);
					}
				}
			}
		}
	}

	public void treeToLs (LinkedList<Comparable> ls){
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
	
	public void convert(Comparable [] array, int n){
		Abb cargar = new Abb();
		Comparable min;
		for(int i = 0; i < n; i++){ cargar.insert(array[i]);}
		for(int i = 0; i < n; i++){ 
			min = cargar.min();  
			array[i] = min;
		}
	}
		
	public boolean repOk(){
		LinkedList<Comparable> ls = new LinkedList<Comparable>(	);
		treeToLs(ls);
		Integer i = 0;
		boolean condition = true;
		while(i < (ls.size() - 1) && condition){
			condition = (ls.get(i).compareTo(ls.get(i+1)) < 0);
			i++;
		}
		//verificar si la lista esta ordenada pos I < pos I+1 de la lsita 
		return condition;
	}
}
