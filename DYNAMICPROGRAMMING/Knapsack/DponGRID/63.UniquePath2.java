//lc-63


class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int r=g.length;
        int c=g[0].length;
        int dp[][]=new int[r][c];
        boolean visit=false;
       for(int i=0;i<c;i++)
       {
          if(visit||g[0][i]==1)
          {
              visit=true;
              dp[0][i]=0;
          }
          else dp[0][i]=1;
       }
       visit=false;
       for(int i=0;i<r;i++)
       {
          if(visit||g[i][0]==1)
          {
              visit=true;
              dp[i][0]=0;
          }
          else dp[i][0]=1;
       }
       for(int i=1;i<r;i++)
       {
           for(int j=1;j<c;j++)
           {
               if(g[i][j]==1)dp[i][j]=0;
               else dp[i][j]=dp[i-1][j]+dp[i][j-1];
           }
       }
        return dp[r-1][c-1];
    }
}
