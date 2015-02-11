package map;



public class HsMapuser {

	public static void main(String arg[]){
		HashMap<String,String> hm= new HashMap<String, String>();
		//put(k,v) 				success
		//contains(k) 			success
		//contains(Mapnode(KV)	success;
		//clear() 				success;
		//displayseq() 			failed
		//display()				success;
		//remove(MapNode(k,v)	success;
		//remove(k)				success;
		
		
		for(int i=0;i<100;i++){
			hm.put(("key"+i),("val"+i));
		}
		//hm.display();
//		hm.clear();
		hm.displayseq();
		hm.remove("key55");
		hm.displayseq();
		
//		System.out.println(hm.remove(new MapNode<String,String>("key90", "val3")));
//		hm.remove("key3");
//		for(int i=0;i<5;i++){
//			System.out.println(hm.contains(("key"+i)+" key "+ "key"+i));
////			System.out.println(hm.contains(new MapNode<String, String>("key"+i,"value"+i)));
//		}

		//		for(int i=0;i<10;i++){
		//			hm.displayseq();
		//			}

	}
}
