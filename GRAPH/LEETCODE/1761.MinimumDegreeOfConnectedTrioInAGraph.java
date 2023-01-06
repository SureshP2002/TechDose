//Lc-1761

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean vis[][]=new boolean[n][n];//creating the visited array
        int inx[]=new int[n+1];
        for(int[] i:edges)
        {
            vis[i[0]-1][i[1]-1]=true;
            vis[i[1]-1][i[0]-1]=true;//making true for visited index
            inx[i[0]-1]++;//inc the incoming edges for both vertex
            inx[i[1]-1]++;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(vis[i][j]&&vis[j][k]&&vis[i][k])//finding trio
                    {
                        res=Math.min(res,inx[i]+inx[j]+inx[k]-6);//-6 is for edges between thme
                    }
                }
                
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
