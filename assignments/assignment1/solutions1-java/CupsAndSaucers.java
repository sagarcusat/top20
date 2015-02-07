public class CupSaucer {
	public static void main(String arg[]){
		int []c={ 15, 20, 20, 22, 30, 89 };
		int s[] = { 10, 19, 26};
		int pair=findMaxPair(c, s);
		System.out.println("pairs are "+pair);

	}
	
	//useses half exclusions
	public static int findMaxPair(int [] c,int [] s){
		int pair=0;

		for(int i=c.length-1,j=s.length-1;(i>=0&&j>=0);){
			//			for(int j=s.length-1;c[i]<=s[j];j--){
			if(s[j]<c[0]){
				return pair;
			}
			i=findsmallcup(c, i, s[j]);
			if(s[j]>=c[i]){
				System.out.println(" ("+c[i]+", "+s[j]+")");
				pair++;
				--i;
				--j;
			}
			//}
		}

		return pair;
	}

	static int findsmallcup(int []c,int lindex,int s){
		
		int sin=0;
		int lin=lindex;
		int mid=(lin+sin)/2;
		while(lin>sin){
			

			if(c[mid]>s){
				lin=mid-1;
				mid=(lin+sin)/2;
			}
			if(c[mid]<s){
			sin=mid+1;
			mid=(sin+lin)/2;
			}if(c[mid]==s){
				return mid;
			}
		}
		return mid;


	}
	
}
