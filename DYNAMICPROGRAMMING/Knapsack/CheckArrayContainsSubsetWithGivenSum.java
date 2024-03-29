//(0/1) Knapsack

public class Solution {
    public int solve(int[] A, int B) {
        int n=A.length;
        boolean dp[][]=new boolean[n+1][B+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=B;j++)
            {
                if(j==0)dp[i][j]=true;
                else if(i==0&&j>0)dp[i][j]=false;
                else if(A[i-1]>j)dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]|dp[i-1][j-A[i-1]];
            }
        }
        for(int i=1;i<=n;i++)
        {
                if(dp[i][B])return 1;
            
        }
        return 0;
    }
