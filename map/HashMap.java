package map;

public class HashMap<K,V> {
	private final int INIT_SIZE=11;

	private int loadFactor =7;
	private MapNode<K,V> []array;
	public MapNode<K,V> displaySeq;
	public int size;

	public HashMap(){
		size=0;
		//create array with inital size
		array= new MapNode[INIT_SIZE];
		size=0;
		//		adds a dummy node at all the index
		for (int index=0;index<array.length;index++){
			array[index]=new MapNode<K,V>();
		}
		//initalise dispaly sequence with a dummy node;
		//it is doubly circular linked list with insertion order;
		displaySeq=new MapNode<K,V>();
		displaySeq.seqnext=displaySeq;
		displaySeq.seqprev=displaySeq;
	}
	//clears the map and removes every element


	public void clear(){
		size=0;
		array=null;
		displaySeq.prev=displaySeq;
		displaySeq.next=displaySeq;

	}

	//display in random order
	public void display(){
		
		for(int i=0;i<array.length;i++){
			MapNode<K, V> current=array[i].next;
			System.out.println("\n Bucket :"+i);
			while(current!=null ){
				System.out.print(" {"+current+"} ");
			current=current.next;
			}
			
		}

	}

	//returns size of the hashMap
	public int size(){
		return size;
	}
	//searches for an element and return true /false
	public boolean contains(MapNode<K,V> t){
		if(size==0)
			return false;
		int index=t.hashCode()%array.length;
		MapNode<K, V> current=array[index];
		//if current.next is null the bucket is empty;
		if(current.next==null){
			return false;
		}
		current=current.next;

		while(current!=null){
			//return if current element is same as searching elem; else increement pointer;
			if(current.equals(t))
				return true;

			current=current.next;
		}
		return false;

	}




	//searches for an element and return true /false
	public boolean contains(K elem){
		if(size==0)
			return false;
		MapNode<K, V> t=new MapNode<K,V>(elem,null);
		return contains(t);

	}


	//display the order in which the elements are added
	public void displayseq(){
		if(size==0){
			System.out.println("Empty Map");
			return;
		}
		MapNode<K, V> current=displaySeq.seqnext;
		System.out.print("[ ");
		while(current!=displaySeq){
			System.out.print(" {"+current+"} ");
			current=current.seqnext;			
		}
		System.out.println(" ]");

	}

	//returns value of key is passed
	public V  get(K key){
		int index=key.hashCode()%array.length;
		MapNode<K, V> current=array[index].next;

		while(current!=null){
			if(current.key.equals(key))
				return current.value;

			current=current.next;
		}

		return null;

	}
	//returns true if added or false if key already added;
	public boolean put(K key,V val){
		MapNode<K, V> elem=new MapNode<K,V>(key,val);
		
		if (contains(elem))
			return false;

		if((size/array.length)>=loadFactor){
			System.out.println("rehashing");
			rehash();
		}



		//		int index=elem.hashCode()%array.length;
		//		MapNode<K, V> current=array[index];
		//		//traverse till last of the list
		//		while(current.next!=null){
		//			current=current.next;
		//		}
		//		//add the element at the last of list;
		//		current.next=elem;
		//		elem.prev=current;
		
		boolean res=addInBucket(array, elem);
		
		if(res){
			//add the element in the displaylist  before the display seq;
			elem.seqnext=displaySeq;
			elem.seqprev=displaySeq.seqprev;
			displaySeq.seqprev.seqnext=elem;
			displaySeq.seqprev=elem;

			size++;
			return true;
		}

		return false;
	}

	public boolean remove(K key){
		return remove(new MapNode<K, V>(key,null));
	}

	//removes the passed element form hash map returns false if element not present;
	public boolean remove(MapNode<K, V> elem){
		//checks if map is empty;
		if(size==0){
			return false;
		}

		int index=elem.hashCode()%array.length;
		MapNode<K, V> current=array[index].next;

		//if bucket is empty;
		if(current==null)
			return false;

		while(current!=null){
			if(current.key.equals(elem.key)){
				//removes the pointer of the current node to be removed form other nodes;

				if(current.next==null){
					current.prev.next=null;
				}else{
					current.prev.next=current.next;
					current.next.prev=current.prev;
				}
				current.next=null;
				current.prev=null;

				current.seqprev.seqnext=current.seqnext;
				current.seqnext.seqprev=current.seqprev;
				current.seqnext=null;
				current.seqprev=null;

				size--;
				return true;
			}
			current=current.next;
		}

		return false;
	}

	//rehashes the map to double the size
	private void rehash() {
		//creates a newArray with double the size of the array 
		MapNode<K, V> []newarray=new MapNode[array.length*2];
		//for each bucket of the new array create a dummy node;
		for (int index=0;index<newarray.length;index++){
			newarray[index]=new MapNode<K,V>();
		}

		//for each array index list remove and add in new array;
		for(int index=0;index<array.length;index++){
			MapNode<K, V> current;
			for(current=array[index].next;current!=null;){
				MapNode<K, V> temp=current.next;

				//remove the links of current node from the bucket 
				if(temp==null){
					current.prev=null;
				}
				else{
					temp.prev=current.prev;
					current.prev.next=temp;
				}
				current.next=null;
				current.prev=null;


				//add the current element removed in newarray 
				addInBucket(newarray, current);

				current=temp;
			}
		}
		array=newarray;
	}



	/**
	 * @param newarray
	 * @param current
	 * add elements to the array passed 
	 */
	private boolean addInBucket(MapNode<K, V>[] newarray, MapNode<K, V> elem) {
		int index=elem.hashCode()%newarray.length;
		MapNode<K, V> temp1=newarray[index];
		//at the begining of list
		if(newarray[index].next==null){
			newarray[index].next=elem;		
		}else{
			elem.next=newarray[index].next;
			elem.prev=newarray[index];
			newarray[index].next.prev=elem;
			newarray[index].next=elem;
			
		}
		return true;
		//		while(temp1.next!=null){
		//			temp1=temp1.next;
		//		}
		//		//add the element at the last of list;
		//		temp1.next=elem;
		//		elem.prev=temp1;

	}

}
