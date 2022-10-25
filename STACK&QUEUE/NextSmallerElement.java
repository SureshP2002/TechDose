//approach-stack

package nextsmallerelement;
import java.util.*;


public class NextSmallerELement {
    static int[] NextSmaller(int nums[],int n)
    {
        int right[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i])
            {
                st.pop();
            }
            right[i]=st.isEmpty()?-1:nums[st.peek()];
            st.push(i);
        }
        return right;
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
                int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(NextSmaller(arr,n)));
    }
    
}
