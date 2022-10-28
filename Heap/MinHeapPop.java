//TC-O(logn)
//top down approach;

package minheappop;
import java.util.*;


public class MinHeapPop {
   static void Heapify(int arr[],int i)
   {
       int sml=i;//min Heapifylogn
       int L=2*i;
       int R=2*i+1;
       if(R>=arr.length||L>=arr.length)return ;
       if(L<arr.length&&arr[L]<arr[i])sml=L;
       if(R<arr.length&&arr[R]<arr[sml])sml=R;
       if(sml!=i)
       {
           int t=arr[i];
           arr[i]=arr[sml];
           arr[sml]=t;
           Heapify(arr,sml);
       }
   }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,2,5,7,10,12,20,30};
        int min=arr[1];//taking first element
        arr[1]=arr[arr.length-1];//adding last element to first
        arr=Arrays.copyOf(arr, arr.length-1);//creating a new array
        Heapify(arr,1);//caaling heapify
        System.out.println(min);//minimum
        System.out.print(Arrays.toString(arr));
    }
    
}
