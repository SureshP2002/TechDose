//LC-994

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();//creating an queue
        int [][]dir={{0,1},{1,0},{-1,0},{0,-1}};//creating an direction matrix
        int m=grid.length;//finding row size
        int n=grid[0].length;//finding col size
        int fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)q.add(new int[]{i,j});//if any rotten orange  found add the index into the queue
                if(grid[i][j]==1)fresh++;//if good add it to fresh
            }
        }
        int min=0;
        int size=0;
        if(fresh==0)return 0;//if fresh is 0 then there is no good one
        while(!q.isEmpty())//untill the queue is empty
        {
        size=q.size();//finding the size
            for(int i=0;i<size;i++){
            int pos[]=q.poll();//polling the first index from q and put it to array
            for(int[] d:dir)//checking for four sides
            {
                int x=pos[0]+d[0];
                int y=pos[1]+d[1];
                if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1)//if the adjacent side is 1 then make it 1 and decrease freshh
                {
                    fresh--;
                    grid[x][y]=2;//make as 2
                    q.add(new int[]{x,y});// add the curent rotten index to qqueue
                }
            }
        }
            min++;//increase the min
        }
        return fresh==0?min-1:-1;//fresh is 0 return min-1 else return -1;
    }
}
