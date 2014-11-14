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

	//Retorna la raiz
	public Comparable getRoot(){
		return element;
	}

   //Setea la raiz
	public void setRoot(Comparable item){
		element = item;
	}

   //Dice si el arbol es vacio
 	public boolean isEmpty(){
 		return element == null;
 	}

   //Remueve todo los nodos del arbol
	public void makeEmpty(){
		element = null;
		hi = null;
		hd = null;
	}

   //Recorrido preOrder
 	public void printPreOrder(){
 		//Se imprime la raiz
 		if(element != null) 
  			System.out.print(element+" ");
    	//Se recorre el hi
  		if (hi != null){
       		hi.printPreOrder();
		}
		//Se recorre el hd
   		if (hd != null){
       		hd.printPreOrder();
		}
 	}//Fin printPreOrder

   //Recorrido postOrder
 	public void printPostOrder(){
 		//Se recorre el hi
  		if (hi != null){
      		hi.printPostOrder();
		}
		//Se recorre el hd
  		if (hd != null){
      		hd.printPostOrder();
		}
		//Se imprime la raiz
		if(element != null) 
  			System.out.print(element+" ");
 	}//Fin printPostOrder

	//Recorrido inOrder
 	public void printInOrder(){
 		//Se recorre el hi
 		if (hi != null){
    		hi.printInOrder();
		}
		//Se imprime la raiz
		if(element != null) 
			System.out.print(element+" ");
  		//Se recorre el hd
 		if (hd != null){
  		hd.printInOrder();
 		}
 	}//Fin printInOrder
 	
	//Encontrar un elemento especifico en el arbol 
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
	}//Fin search
	 
	//Retorna el minimo elemento del arbol
 	public Comparable min(){
 		if(hi != null && hi.element != null){
 			return hi.min();
 		}
 		else {
	 		return element;
	 	}
	}
    //Retorna el maximo elemento del arbol
 	public Comparable max(){
 		if(hd != null && hd.element != null){
 			return hd.max();
 		}
 		return element;
 	}

 	//Borrar un elemento
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
 	}//Fin delete

   	//Insertar un elemento
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
	}//Fin insert
	
	
	public void treeToLs (LinkedList<Comparable> ls){
		//Se recorre el hi
 		if (hi != null){
    		hi.treeToLs(ls);
		}
		if(element != null) 
			ls.add(element);
  		//Se recorre el hd
  		if (hd != null){
  			hd.treeToLs(ls);
 		}
	}//Fin treeTols
	
	//Carga los elementos de un array en un Abb y los retorna al array(Ordenados)
	public void convert(Comparable [] array, int n){
		Abb cargar = new Abb();
		Comparable min;
		for(int i = 0; i < n; i++){ cargar.insert(array[i]);}
		for(int i = 0; i < n; i++){ 
			min = cargar.min();
			cargar.delete(min);  
			array[i] = min;
		}
	}//Fin convert
		
	public boolean repOk(){
		LinkedList<Comparable> ls = new LinkedList<Comparable>(	);
		treeToLs(ls);
		Integer i = 0;
		boolean condition = true;
		while(i < (ls.size() - 1) && condition){
			condition = (ls.get(i).compareTo(ls.get(i+1)) < 0);
			i++;
		}
		//Verificar si la lista esta ordenada pos I < pos I+1 de la lsita 
		return condition;
	}//Fin repOk
}//Fin clase Abb
