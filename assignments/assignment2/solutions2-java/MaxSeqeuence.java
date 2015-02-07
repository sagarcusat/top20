public class LinkedList <T>{

	private ListNode<T> header;
	private int size;
	//private ListNode<T> last;


	// displays list
	public void displayList(){
		if(header==null){
			System.out.println("Empty list");
			return ;
		}
		ListNode<T> current=header.next;

		System.out.println("size of list is : "+getSize(header) +" Elements");
		while(current!=null){
			System.out.print(current.elem+" ");
			current=current.next;
		}
		System.out.println( );
	}
	
	//return size of the list
	public  int getSize(ListNode<T> header){
		int length=0;
		header=header.next;
		while(header!=null){
			++length;
			header=header.next;
		}
		return length;
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
	// returns ture or false if searched for an element
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
	
	//find middle elemnt of the list
	public ListNode<T> findMiddle(){

		if(header==null){
			return null ;
		}

		ListNode<T> slow,fast;
		slow=header.next;
		fast=slow;

		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	//find First common node of a list
	public  ListNode<T> findFirstCommon(ListNode<T> header1,ListNode<T> header2){

		int n=getSize(header1);
		int m=getSize(header2);

		header1=header1.next;
		header2=header2.next;
		int lenDiff=Math.abs(m-n);
		ListNode<T> h1,h2;
		if(n>=m){
			h1=header1;
			h2=header2;
		}
		else{
			h1=header2;
			h2=header1;
		}
		// header of the longer list to a element to make both list of equal size now
		for(int i=0;i<lenDiff;i++){
			h1=h1.next;
		}
		while(h1!=h2){
			h1=h1.next;
			h2=h2.next;
		}
		return h1; 
	}


	//splitList
	public void splitList(){
		
		ListNode<T> fast,slow;
		fast=header;
		slow=header;
		
		while(fast.next!=null&& fast!=null){
			if(fast.next.next==null){
				slow=slow.next;
			}
			fast=fast.next.next;
			slow=slow.next;
		}
		fast.next=header.next;
		header.next=slow.next;
		slow.next=null;
	}
	
	///assignment find max continous node of either R or B;
	public  int findMaxNode(){
		int maxR=0;
		int maxB=0;
		int max=0;
		String elm;
		if(header==null)
			return max;

		ListNode<T> current=header.next;
		elm=String.valueOf(current.elem);

		while(current!=null){
			if(!current.elem.equals(elm)){
				
				if(max<maxB||max<maxR){
					if(maxB>maxR)
						max=maxB;
					else
						max=maxR;
				}
				if(current.elem.equals("R")){
					maxR=1;
					maxB=0;
					elm="R";
				}
				else{
					maxR=0;
					maxB=1;
					elm="B";
				}
			}
			else{
				if(current.elem.equals("B"))
					maxB++;				
				else
					maxR++;
			}
			current=current.next;
		}
		return max;
	}

}
