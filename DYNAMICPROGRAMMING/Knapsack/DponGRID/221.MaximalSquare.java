//lc-221

class Solution {
    public int maximalSquare(char[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int lar=Integer.MIN_VALUE;
        int dp[][]=new int[r+1][c+1];
        for(int i=0;i<=r;i++)
        {
            for(int j=0;j<=c;j++)
            {
                if(i==0||j==0)
                      dp[i][j]=0;
                else if(matrix[i-1][j-1]=='1')
                      dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                lar=Math.max(lar,dp[i][j]);

            }
        }
        return lar*lar;
    }
}
