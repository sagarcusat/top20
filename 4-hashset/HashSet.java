package hashset;

import hashset.LinkedList;
import hashset.ListNode;

public class HashSet<T> implements Set{

	private static final int INIT_SIZE=3;
	private static final int THRESHHOLD=3;
	int size=0;

	private LinkedList<T> [] array;

	public HashSet(){
		array=new LinkedList[INIT_SIZE];

		//allocates dummy node to each bucket
		for(int i=0;i<INIT_SIZE;i++){
			array[i]=new LinkedList();
		} 
	}


	//returns the Size of the Hashset
	public int size() {
		return size;
	}


	//returns true or false according to the element searched
	public boolean contains(Object elem) {
		int index=((T)elem).hashCode()%array.length;

		return   array[index].contains((T)elem);
	}

	//checks if the size exceeds THRESHHOLD and rehash other wise add an element 
	//after finding Index of the bucket;

	public boolean add(Object elem) {

		//check threshhold
		
		if((size/array.length)>THRESHHOLD){
			System.out.println("Rehashing...");
			rehash();
		}

		// add the element
		int index=((T)elem).hashCode()%array.length;
		
		//		checks if already present
		boolean res=array[index].contains((T)elem);
		if(!res){
			size++;
			res= array[index].add((T)elem);
			System.out.println(elem+" added ");
			return res;
		}
		return false;
	}


	public boolean remove(Object elem) {
		int index=((T)elem).hashCode()%array.length;

		boolean res=array[index].remove((T)elem);
		if(res){
			--size;
		}
		return res;
	}


	@Override
	//display all the elements bucket by bucket
	public void display() {
		System.out.println("size of HashSet is "+size);
		for(int i=0;i<array.length;i++){
			array[i].displayList();
		}
	}

	//used to rehash if the size exceeds threshhold;
	private void rehash(){
		//allocate memory for new array;
		LinkedList<T> []newarr= new LinkedList[2*array.length];
		//attach dummynode to each bucket
		for(int i=0;i<newarr.length;i++){
			newarr[i]=new LinkedList();
			
		}
		
		
		//for each element in old array rehash 
		for(int i=0;i<array.length;i++){
			
			int listlen=array[i].getSize();
			for(int j=0;j<listlen;j++){
				ListNode<T> node=(array[i].getElem());
				int hscode=node.getElem().hashCode();
				int newindex=hscode%(newarr.length);
				boolean res=newarr[newindex].add(node);
				

//				newArray[index].add(node);
				}
			}
		array=newarr;
	}
}
