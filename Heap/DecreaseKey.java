//TC-O(Logn)
//percolate down 


package decreasekey;

import java.util.Arrays;
import java.util.Scanner;


public class DecreaseKey {
     static void Heapify(int arr[],int i)
     {
         int lar=i;
       int L=2*i;
       int R=2*i+1;
       if(L>=arr.length||R>=arr.length)return ;//if size exceeds return the arr
       if(L<arr.length&&arr[L]>arr[lar])//finding large in left
       {
           lar=L;
       }
       if(R<arr.length&&arr[R]>arr[lar])//finfing large in right
       {
           lar=R;
       }
       if(lar!=i)//if large is not the curr index
       {
           int t=arr[lar];//swaoing them
           arr[lar]=arr[i];
           arr[i]=t;
           Heapify(arr,lar);//recursive call for next
       }
      
     }
    static void Dcrkey(int arr[],int ind,int dif)
    {
        arr[ind]+=dif;
        Heapify(arr,ind);//function call for heapify from the given index
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int arr[]={0,9,8,7,6,5,4,3,3,1,0,-1};
        Dcrkey(arr,2,-8);//decreamenting the value at the index
        System.out.println(Arrays.toString(arr));
    }
    
}
