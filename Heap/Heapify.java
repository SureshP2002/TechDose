//TC-O(log n)
//approach- top-down approach(percolate down)


package heapify;

import java.util.Arrays;
import java.util.Scanner;


public class Heapify {
     static int[] MaxHeap(int arr[],int i)
   {
       
       int lar=i;
       int L=2*i;
       int R=2*i+1;
       if(L>=arr.length||R>=arr.length)return arr;//if size exceeds return the arr
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
           MaxHeap(arr,lar);//recursive call for next
       }
      
       return arr;
       
   }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,2,5,7,1};
        System.out.println(Arrays.toString(MaxHeap(arr,1)));//max heapifying
    }
    
}
