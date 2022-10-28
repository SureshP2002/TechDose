//TC-O(logn)
//top down approach

package minheapify;
import java.util.*;


public class MinHeapify {
    
    static void heapify(int arr[],int i)
    {
        int sml=i;//small as curr index
        int L=2*i;//left child
        int R=2*i+1;//right child
        if(L>=arr.length||R>=arr.length)return;//if i exceeds length return 
        if(L<arr.length&&arr[L]<arr[i])sml=L;//left is small than curr update
        if(R<arr.length&&arr[R]<arr[sml])sml=R;//right is small than smll update
        if(sml!=i)//if small is not equal curr index
        {
            int t=arr[i];//swaping them
            arr[i]=arr[sml];
            arr[sml]=t;
            heapify(arr,sml);//recursive call
         }
    }
    
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int arr[]={0,10,5,2,20,30,15,7};
       heapify(arr,1);//function call
       System.out.println(Arrays.toString(arr));
    }
    
}
