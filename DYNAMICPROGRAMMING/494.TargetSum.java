//(0/1) Knapsack


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n=nums.length;
        for(int i:nums)sum+=i;//finding total sum
        if(sum+target<0||sum<target||(sum-target)%2==1)return 0;//if target less greater than sum or target negative or whether it is odd means return 0;

        int t=(sum+target)/2;//s1-(sum-s1)=diff//2s1-sum=diff//s1=(sum+diff)/2;
        int dp[][]=new int[n+1][t+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=t;j++)
            {
                   
                  if(nums[i-1]>j)dp[i][j]=dp[i-1][j];
                  else dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][t];
    }
}
