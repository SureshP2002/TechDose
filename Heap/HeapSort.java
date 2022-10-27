//TC-O(nlogn)
//build heap +heapify

package heapsorttechnique;

import java.util.Arrays;
import java.util.Scanner;


public class Heapsorttechnique {
    static void Heapify(int arr[],int n,int i)
    {
        int lar=i;
       int L=2*i;
       int R=2*i+1;
       if(L>=n||R>=n)return ;//if size exceeds return the arr
       if(L<n&&arr[L]>arr[lar])//finding large in left
       {
           lar=L;
       }
       if(R<n&&arr[R]>arr[lar])//finfing large in right
       {
           lar=R;
       }
       if(lar!=i)//if large is not the curr index
       {
           int t=arr[lar];//swaping them
           arr[lar]=arr[i];
           arr[i]=t;
           Heapify(arr,n,lar);//recursive call for next
       }
    }

     static void sort(int arr[])
    {
        int n=arr.length;
        //build heap(rearrange array)
        for(int i=(n/2)-1;i>=0;i--)
        {
            Heapify(arr,n,i);
        }
        //one bye one extract the top element and replace with last
        for(int i=n-1;i>0;i--)
        {
            int t=arr[0];//swaping
            arr[0]=arr[i];
            arr[i]=t;
            Heapify(arr,i,0);//recursive call with reduced size i
        }
       
    }
    public static void main(String[] args) {
                Scanner sc=new Scanner(System.in);
        int arr[]= { 12, 11, 13, 5, 6, 7 };//initializing an array
        sort(arr);//function call
        System.out.println(Arrays.toString(arr));

    }
    
}
