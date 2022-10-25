//approach-stack


package previoussmallerelemnet;
import java.util.*;

public class PreviousSmallerElemnet {
    
     static int[] PreviousSmaller(int nums[],int n)
    {
        int left[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i])
            {
                st.pop();
            }
            left[i]=st.isEmpty()?-1:nums[st.peek()];
            st.push(i);
        }
        return left;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(PreviousSmaller(arr,n)));
    }
    
}
