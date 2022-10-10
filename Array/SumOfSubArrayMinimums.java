//leetcode-907;
//Approach-Stack;
//TC-O(N);


class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans=0;
        Stack<Integer> stack=new Stack<Integer>();
        long m=(long)1e9+7;
        stack.push(-1);
        for(int i=0;i<arr.length+1;i++)
        {
        int c=(i<arr.length)?arr[i]:0;
            while(stack.peek()!=-1&&c<arr[stack.peek()])
            {
                int ind=stack.pop();
                int k=stack.peek();
                int left=ind-k;
                int right=i-ind;
                long add=(long)(left*right*(long)arr[ind])%m;
                ans+=add;
                ans%=m;
            }
            stack.push(i);
        
        }
        return (int)ans;
        
    }
}
