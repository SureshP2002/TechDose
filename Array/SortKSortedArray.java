//Approach-Minheap
//TC-O(m*log(k))


import java.util.*;
public class Main
{
    static void SortK(int n,int arr[],int k)
    {
        if(arr==null||arr.length==0)//if no element
        return ;
        PriorityQueue<Integer> ans=new PriorityQueue<>();//queue for minHeap
        int minCount=Math.min(k+1,n);
        for(int i=0;i<minCount;i++)
        {
            ans.add(arr[i]);//adding first k+1 elements in the  minHeap
        }
        int index=0;
        for(int i=k+1;i<n;i++)
        {
            arr[index++]=ans.peek();//puuting peek element in arr
            ans.poll();//removing peek
            ans.add(arr[i]);//adding elements form k+1;
        }
        
        while(index<n)
        {
            arr[index++]=ans.peek();//finally adding the minHeap elements in array
            ans.poll();
        }
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
	    SortK(n,arr,k);
	    for(int i=0;i<n;i++)
	    {
	        System.out.print(arr[i]+" ");
	    }
		
	}
}
