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

	   //Dice si el arbol es vacio
 	public boolean isEmpty(){
 		return element == null;
 	}


 	
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
	
	
	//Carga los elementos de un array en un Abb y los retorna al array(Ordenados)
	public static void treeSort(Comparable [] array, int n){
		Abb load = new Abb();
		Comparable min;
		for(int i = 0; i < n; i++){ load.insert(array[i]);}
		for(int i = 0; i < n; i++){ 
			min = load.min();
			load.delete(min);  
			array[i] = min;
		}
	}//Fin convert
		
}//Fin clase Abb
