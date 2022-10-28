//Tc-O(logn)
//bottom up

package minheappush;
import java.util.*;


public class MinHeapPush {
    static int [] Minpush(int arr[],int val)
    {
         arr=Arrays.copyOf(arr, arr.length+1);
         arr[arr.length-1]=val;
         int i=arr.length-1;
         while(i>1&&arr[i/2]>arr[i])
         {
             int s=arr[i];
             arr[i]=arr[i/2];
             arr[i/2]=s;
             i/=2;
         }
         return  arr;
        
    }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,2,5,7,20,30,15,10};
        arr=Minpush(arr,1);
        System.out.println(Arrays.toString(arr));
    }
    
}
