//TC-O(nlogn)
//buildMinHeap+Heapify 

package heapsortdecending;
import java.util.*;



public class HeapSortDecending {
        static void heapify(int arr[],int n,int i)
    {
        int sml=i;//small as curr index
        int L=2*i;//left child
        int R=2*i+1;//right child
        if(L>=n||R>=n)return;//if i exceeds length return 
        if(L<n&&arr[L]<arr[i])sml=L;//left is small than curr update
        if(R<n&&arr[R]<arr[sml])sml=R;//right is small than smll update
        if(sml!=i)//if small is not equal curr index
        {
            int t=arr[i];//swaping them
            arr[i]=arr[sml];
            arr[sml]=t;
            heapify(arr,n,sml);//recursive call
         }
    }
     static void sort(int arr[])
    {
        int n=arr.length;
        //build heap(rearrange array)
        for(int i=(n/2)+1;i>=0;i--)
        {
            heapify(arr,n,i);
        }
        //one bye one extract the top element and replace with last
        for(int i=n-1;i>0;i--)
        {
            int t=arr[0];//swaping
            arr[0]=arr[i];
            arr[i]=t;
            heapify(arr,i,0);//recursive call with reduced size i
        }
       
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            
        int arr[]= { 1,2,3,4,5,6,7,8,9,5 };//initializing an array
        sort(arr);//function call
        System.out.println(Arrays.toString(arr));
        
    }
    
}
