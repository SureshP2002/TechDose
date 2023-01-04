//LC-1020

class Solution {
    int count=0;
    public void Dfs(int mat[][],int i,int j)
    {
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]==0)return;
        mat[i][j]=0;
        Dfs(mat,i+1,j);
        Dfs(mat,i-1,j);
        Dfs(mat,i,j+1);
        Dfs(mat,i,j-1);
    }
    public int numEnclaves(int[][] grid) {
      int n=grid.length,m=grid[0].length;
      for(int j=0;j<m;j++)
      {
          if(grid[0][j]==1)Dfs(grid,0,j);
          if(grid[n-1][j]==1)Dfs(grid,n-1,j);
      }
      for(int i=0;i<n;i++)
      {
          if(grid[i][0]==1)Dfs(grid,i,0);
          if(grid[i][m-1]==1)Dfs(grid,i,m-1);
      }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)count++;
            }
        }
        return count;
    }
}
