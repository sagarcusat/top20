package hashset;

public class LinkedList <T>{

	private ListNode<T> header;
	private int size;
	//private ListNode<T> last;

public LinkedList(){
	header= new ListNode<T>();
	size=0;
}

	public void displayList(){
		if(header==null){
			System.out.println("Empty list");
			return ;
		}
		ListNode<T> current=header.next;
		System.out.print("size  : "+getSize() +" Elements \t");
		while(current!=null){
			System.out.print(current.elem+"\t ");
			current=current.next;
		}
		System.out.println( );
	}


	//return element at first element removing the first element
	public ListNode<T> getElem(){
		if(header==null||header.next==null)
			return null;
		
		ListNode<T> current=header.next;
		 remove(current);
		return current;
	}

	

	public  int getSize(){
		int length=0;
		ListNode<T> temp=header.next;
		while(temp!=null){
			++length;
			temp=temp.next;
		}
		return length;
	}




	//add a given node to list;
	public boolean add(ListNode<T> node){
		
		
		ListNode<T> current=header.next,prev=header;

		//traverse till end of the list
		while(current!=null ){
			prev=current;
			current=current.next;
		
		}

		//add new node to list and return true
		prev.next=node;
		++size;
return true;		
		
	}	

	
	//add at last of the list	
	public boolean add(T elem){
		if(header==null){
			header=new ListNode<T>();
			header.next=null;
			size=0;

		}

		ListNode<T> temp= new ListNode<T>(elem);
		ListNode<T> current=header;

		//traverse till end of the list
		while(current.next!=null){
			current=current.next;
		}

		//add new node to list and return true
		current.next=temp;
		++size;
		return true;
	}	




	//checks if the node is present returns true else 
	//returns false

	public boolean contains(T elem){
		if(header==null){
			return false;
		}
		ListNode<T> current=header.next;

		while (current!=null){
			if(current.elem.equals(elem))
				return true;
			current=current.next;
		}

		return false;
	}


	//searches and removes the element when passed to function 
	public boolean remove(T elem){
		if(header.next==null)
			return false;

		ListNode<T> current=header.next,prev;
		prev=header;
		while(current!=null){

			if(current.elem.equals(elem)){
				//if elemnet is found remove the node 
				prev.next=current.next;
				return true;
			}
			prev=current;
			current=current.next;
		}
		return false;
	}
	
	
	//searches and removes a node when passed to the funtion 
public boolean remove(ListNode<T> node){
		
		if(header==null || header.next==null)
			return false;
		
		ListNode<T> current=header,prev=header;
		while(current!=null && current!=node){
			prev=current;
			current=current.next;
		}
		if(current==null)
			return false;
		
		prev.next=current.next;
		current.next=null;
		return true;
		
	}
}




