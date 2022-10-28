//TC_O(logn)
//percolate up

package increasekey;
import java.util.*;


public class IncreaseKey {
   
    static void Inckey(int arr[],int index,int val)
    {
        arr[index]+=val;//increamneting value at the index
        int i=index;//bottom up from given index
        while(i>1&&arr[i/2]<arr[i])
        {
            int t=arr[i/2];//swaping them
            arr[i/2]=arr[i];
            arr[i]=t;
            i/=2;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,9,8,7,6,5,4,3,2,1,0,-1};
        Inckey(arr,5,4);//incrementing the value at the index
        System.out.println(Arrays.toString(arr));
    }
    
}
