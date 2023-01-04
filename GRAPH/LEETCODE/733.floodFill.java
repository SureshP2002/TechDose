//lc-733


class Solution {
    public void Dfs(int image[][],int i,int j,int color,int source)
    {
        if(i<0||j<0||i>=image.length||j>=image[0].length||image[i][j]!=source)return;
        image[i][j]=color;
        Dfs(image,i+1,j,color,source);
        Dfs(image,i-1,j,color,source);
        Dfs(image,i,j+1,color,source);
        Dfs(image,i,j-1,color,source);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)return image;
       Dfs(image,sr,sc,color,image[sr][sc]); 
        return image;
    }
}
