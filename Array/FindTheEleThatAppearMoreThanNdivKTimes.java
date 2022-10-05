//TC-O(N)
//approach-HAshMap


import java.util.*;
public class Main{
    static List<Integer> ListOfElementsOcurrsNdivKtimes(int arr[],int n,int k)
    {
        List<Integer> a=new ArrayList<Integer>();//creating list to add the elments
        Map<Integer,Integer> ans=new HashMap<Integer,Integer>();//creating HashMap for storing value with key;
        for(int i=0;i<n;i++)
        {
            ans.put(arr[i],ans.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> o:ans.entrySet())//adding it to the list
        {
            if(o.getValue()>n/k)
            {
                a.add(o.getKey());
            }
        }
        return a;
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int arr[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        arr[i]=sc.nextInt();
	    }
	    int k=sc.nextInt();
	    System.out.println(ListOfElementsOcurrsNdivKtimes(arr,n,k));
		
	}
}
