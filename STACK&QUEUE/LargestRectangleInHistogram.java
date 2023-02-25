//leetcode-84
//Tc-O(N^2)

class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length;
        Stack<Integer> st=new Stack<Integer>();
        int maxArea=0;
        int left[]=new int[n];
        for(int i=0;i<n;i++)
        {
            
            while(!st.isEmpty()&&h[st.peek()]>=h[i])
            {
                st.pop();
            }
            left[i]=st.isEmpty()?0:st.peek()+1;
            st.push(i);
            
        }
        System.out.println(Arrays.toString(left));
        int right[]=new int[n];
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&h[st.peek()]>=h[i])
            {
                st.pop();
            }
            right[i]=st.isEmpty()?n-1:st.peek()-1;
            st.push(i);
            maxArea=Math.max(maxArea,(right[i]-left[i]+1)*h[i]);
            
        }
         System.out.println(Arrays.toString(right));
        
        return maxArea;
      
        
    }
}
