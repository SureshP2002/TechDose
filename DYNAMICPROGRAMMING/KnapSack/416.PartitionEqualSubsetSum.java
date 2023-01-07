//(0/1)KnapSack

class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];//finding total sum
        }
        if(sum%2!=0)return false;//if total sum is odd then we cant split into two set
        int target=sum/2;//divide target to check if one of the subset is equal to target
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++)
        {
           for(int j=0;j<=target;j++)
           {
              if(j==0)dp[i][j]=true//first col fully true
              else if(i==0&&j>0)dp[i][j]=false;//first row except 0 is false
              else if(nums[i-1]>j)dp[i][j]=dp[i-1][j];//if prev is true add to it(include)
              else dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];//exclude

           }
        }
        return dp[n][target];
        
        
    }
}
