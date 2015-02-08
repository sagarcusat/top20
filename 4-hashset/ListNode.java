package hashset;



public class ListNode<T> {

	 T elem;
	ListNode<T> next;
	
	public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
	}
	
//	public String toString(){
//		//display();
//		return "";//elem+" ";
//	}


//	public void display(){
//		System.out.println(" "+elem);
//	}
//	
	//zero arg constructor
	public ListNode(){
		elem= null;
		next=null;
	}

	//one arg constructor to initialize elememt value
	public ListNode(T elem){
		this.elem=elem;
		next=null;
	}

	//two arg constructor to initalize
	//next value and elem;
	
	public ListNode(T elem,ListNode<T> next){
		this.elem=elem;
		this.next=next;
	}
	
	
	





}
