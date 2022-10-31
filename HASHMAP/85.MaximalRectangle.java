//leetcode-85
//TC_O(N)
//approach-stack

class Solution {
    public int maximalRectangle(char[][] m) {
        int h[]=new int[m[0].length];//creating an array
        int maxArea=0;//finding maxArea
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                if(m[i][j]!='0')
                h[j]+=m[i][j]-'0';//fiding sum for each array
                else{
                    h[j]=0;
                }
            }
           int n=h.length;
        Stack<Integer> st=new Stack<Integer>();//creating the stack
        int left[]=new int[n];//left array for adding the index of previous smaller element +1
        for(int j=0;j<n;j++)
        {
            
            while(!st.isEmpty()&&h[st.peek()]>=h[j])//poping the element if it is greater than the curr element
            {
                st.pop();
            }
            left[j]=st.isEmpty()?0:st.peek()+1;//if stack is empty add 0 because prev smaller is at 0 else add index+1
            st.push(j);//pushing index
            
        }
        int right[]=new int[n];//right array for adding the index of next greater element -1;
        st.clear();//clear stack
        for(int j=n-1;j>=0;j--)
        {
            while(!st.isEmpty()&&h[st.peek()]>=h[j])//poping element if it is greater than curr element
            {
                st.pop();
            }
            right[j]=st.isEmpty()?n-1:st.peek()-1;//id stack is empty then add n-1 because next smaller element is at last elemnt also
            st.push(j);//psuhing index
            maxArea=Math.max(maxArea,(right[j]-left[j]+1)*h[j]);//finding area ((right-left+1))*currHeigth
            
        }
        
    
       
        
            
        }
        return maxArea;
    }
}
