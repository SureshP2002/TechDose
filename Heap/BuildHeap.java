//TC-O(nLogn)
//heapify

package buildeheap;
import java.util.*;


public class BuildeHeap {
    static void Heapify(int arr[],int i,int n)
    {
        int lar=i;
        int l=2*i;
        int r=2*i+1;
        if(l>=n||r>=n)return;
        if(l<n&&arr[l]>arr[i])lar=l;
        if(r<n&&arr[r]>arr[lar])lar=r;
        if(lar!=i)
        {
            int t=arr[i];
            arr[i]=arr[lar];
            arr[lar]=t;
            Heapify(arr,lar,n);
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
        Scanner sc=new Scanner(System.in);
        int arr[]={0,1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};//initializing the array
        BuildHeap(arr,12);//buildheap
        System.out.println(Arrays.toString(arr));
    }
    
}
