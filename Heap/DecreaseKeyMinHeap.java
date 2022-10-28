//TC-O(logn)
//bottom up

package decreasekeyminheap;
import java.util.*;


public class DecreaseKeyMinHeap {
        static void Deckey(int arr[],int ind,int val)
    {
        arr[ind]+=val;//increment the value
       int i=ind;
       while(i>1&&arr[i/2]>arr[i])//checking if parent node is greter than cjild
       {
           int t=arr[i/2];//swaping
           arr[i/2]=arr[i];
           arr[i]=t;
           i/=2;
       }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,2,5,7,10,12,20,30};
        Deckey(arr,3,-2);//incrementing the value at the index
        System.out.println(Arrays.toString(arr));
    }
    
}
