//TC-O(logn)
//percolate down

package increasekeyminheap;
import java.util.*;


public class IncreaseKeyMinHeap {
    static void Heapify(int arr[],int i)
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
            Heapify(arr,sml);//recursive call
         }
    }
    static void Inckey(int arr[],int ind,int val)
    {
        arr[ind]+=val;//increment the value
        Heapify(arr,ind);//function call
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int arr[]={0,2,5,7,10,12,20,30};
       Inckey(arr,1,6);//incrementing the value at the index
        System.out.println(Arrays.toString(arr));
       
    }
    
}
