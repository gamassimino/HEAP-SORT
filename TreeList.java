public class TreeList{

	public Comparable element;
	public TreeList next;
	public TreeList back;

	//constructor de la lista
	public TreeList(){
		element = null;
		next = null;
		back = null;
	}

	public void insert(Comparable element){
		TreeList aux = new TreeList();
		if (this.element == null){
			this.element = element;
		}
		else{
			aux.element = element;
			aux.next = null;
			aux.back = back;
			next = aux;
		}//end of if-else
	}//end of insert

	public void showList(){
		TreeList aux = new TreeList();
		while (aux.back != null){
			System.out.print(aux.element+" ");
			aux = aux.back; 
		}//end of while
	}//end of showList

}//end of class