//TC-O(logn)
//bottom up approach

package heappush;
import java.util.*;


public class HeapPush {

    static int[] HeapPush(int arr[],int val)
    {
        arr=Arrays.copyOf(arr, arr.length+1);//creating an new array of size +1;
        arr[arr.length-1]=val;//adding element at the last
        int i=arr.length-1;//keeping last index
        while(i>1&&arr[i/2]<arr[i])//checking upto last before index and if parent node is less than child node
        {
            int t=arr[i];//swaping 
            arr[i]=arr[i/2];
            arr[i/2]=t;
            i=i/2;//moving to next parent
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,20,9,8,7,6,5,4,3};
        arr=HeapPush(arr,12);//calling HeapPush function
        System.out.println(Arrays.toString(arr));
        
    }
    
}
