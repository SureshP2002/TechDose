//(0/1) Knapsack

public class Solution {
    public int solve(int[] A) {
        int n=A.length;
        int sum=0;
        for(int i=0;i<n;i++)sum+=A[i];
        
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(j==0)dp[i][j]=true;
                else if(i==0&&j>0)dp[i][j]=false;
                else if(A[i-1]>j)dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]||dp[i-1][j-A[i-1]];
            }
        }
        int target=sum/2;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<=target;i++)
        {
            if((dp[n][i]==true)&&Math.abs(i-(sum-i))<diff)
            diff=Math.abs(i-(sum-i));
        }
        return diff;
    }
}
