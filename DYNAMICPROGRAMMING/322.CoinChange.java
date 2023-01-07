//(UnboundedKnapsack)-DP

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];//creating dp array
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                if(j==0)
                    dp[i][j]=0;//for 0 amount(min is 0)
                else if(i==0)
                    dp[i][j]=100000;//for 0 coind(min is max)
                else if(coins[i-1]>j)
                    dp[i][j]=dp[i-1][j];//exculde if greater
                else 
                     dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);//min(include,exclude);
            }
        }
        return dp[n][amount]>1e4?-1:dp[n][amount];
    }
}
