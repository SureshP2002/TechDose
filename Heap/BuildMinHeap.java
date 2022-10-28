//Tc-O(nlogn)
//top down approach

package buildheap;
import java.util.*;


public class BuildHeap {
    static void Heapify(int arr[],int i,int n)
    {
        int sml=i;
        int l=2*i;
        int r=2*i+1;
        if(l>=n||r>=n)return;
        if(l<n&&arr[l]<arr[i])sml=l;
        if(r<n&&arr[r]<arr[sml])sml=r;
        if(sml!=i)
        {
            int t=arr[i];
            arr[i]=arr[sml];
            arr[sml]=t;
            Heapify(arr,sml,n);
        }
       
    }

   static void BuildHeap(int arr[],int n)
    {
       
        for(int i=(n/2)+1;i>0;i--)//starting from half of the array
        {
            Heapify(arr,i,n);//function call
        }
        
    }
    public static void main(String[] args) {
       Scanner Sc=new Scanner(System.in);
   
        int arr[]={0,10,5,2,20,30,15,7};//initializing the array
        BuildHeap(arr,8);//buildheap
        System.out.println(Arrays.toString(arr));
    }
    
}
