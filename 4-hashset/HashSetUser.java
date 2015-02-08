package hashset;

public class HashSetUser {

	public static void main(String arg[]){
		HashSet<Integer> hs= new HashSet<Integer>();

		 for(int i=0;i<40;i++)
			 hs.add(i);
		hs.remove(12);
		hs.display();
		System.out.println(hs.contains(2));
		
		
	}
}
