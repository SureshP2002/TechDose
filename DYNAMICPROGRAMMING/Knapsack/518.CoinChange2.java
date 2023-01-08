//Unbounded Knapsack

class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                if(j==0)
                   dp[i][j]=1;
                else if(i==0)
                   dp[i][j]=0;
                else if(coins[i-1]>j)
                   dp[i][j]=dp[i-1][j];
                else
                   dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }
}
