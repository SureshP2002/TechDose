//LC-542

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int dis[][]=new int[n][m];
        int vis[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
               if(mat[i][j]==0)
               {
                  q.add(new int[]{i,j,0});
                  vis[i][j]=1;

               }
            }
        }
        int row[]=new int[]{-1,0,1,0};
        int col[]=new int[]{0,1,0,-1};
        while(!q.isEmpty())
        {
            int r=q.peek()[0];
            int c=q.peek()[1];
            int step=q.poll()[2];
            dis[r][c]=step;
            for(int i=0;i<4;i++)
            {
                int nrow=r+row[i];
                int ncol=c+col[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new int[]{nrow,ncol,step+1});
                }
            }
        }
        return dis;
    }
}
