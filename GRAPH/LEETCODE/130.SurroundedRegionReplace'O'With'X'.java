//lc=130

class Solution {
    int r[]=new int[]{-1,0,1,0};
    int c[]=new int[]{0,1,0,-1};
    public void dfs(int vis[][],char mat[][],int n,int m,int curr,int row,int col)
    {
        vis[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int nrow=row+r[i];
            int ncol=col+c[i];
            if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&&mat[nrow][ncol]=='O'&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                dfs(vis,mat,n,m,mat[nrow][ncol],nrow,ncol);
            }
        }

    }
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        int vis[][]=new int[n][m];
        for(int j=0;j<m;j++)
        {
            if(vis[0][j]==0&&board[0][j]=='O')
            dfs(vis,board,n,m,board[0][j],0,j);
            if(vis[n-1][j]==0&&board[n-1][j]=='O')
            dfs(vis,board,n,m,board[n-1][j],n-1,j);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i][0]==0&&board[i][0]=='O')
            dfs(vis,board,n,m,board[i][0],i,0);
            if(vis[i][m-1]==0&&board[i][m-1]=='O')
            dfs(vis,board,n,m,board[i][m-1],i,m-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==1)board[i][j]='O';
                else board[i][j]='X';
            }
        }
       
    }
}
