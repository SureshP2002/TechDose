//leetcode-862
//TC- O(N)
//minimum size sum

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length,res=n+1;
        int Minlength=Integer.MAX_VALUE;
        long[] cummSum=new long[n+1];
        for(int i=0;i<n;i++)
        {
            cummSum[i+1]=cummSum[i]+nums[i];
        }
        Deque<Integer> St=new ArrayDeque<>();
        for(int i=0;i<n+1;i++)
        {
            while(St.size()>0&&cummSum[i]-cummSum[St.getFirst()]>=k)
            {
                res=Math.min(res,i-St.pollFirst());
            }
            while(St.size()>0&&cummSum[i]<=cummSum[St.getLast()])
            {
                St.pollLast();
            }
            St.addLast(i);
        }
        return res==n+1?-1:res;
    }
}
