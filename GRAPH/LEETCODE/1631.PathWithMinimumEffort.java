//LC-1631

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r=heights.length;
        int c=heights[0].length;
        int efforts[][]=new int[r][c];//creating distance matrix
        for(int i=0;i<r;i++)
        {
            Arrays.fill(efforts[i],Integer.MAX_VALUE);//initialy all are maximum
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[2]-b[2]);//creatin pq for selecting min cost
        efforts[0][0]=0;//initially 0 for(0,0)
        pq.add(new int[]{0,0,0});//adding initialy
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};//direction array
        while(!pq.isEmpty())
        {
            int row=pq.peek()[0];//curr row
            int col=pq.peek()[1];//curr col
            int cost=pq.peek()[2];//curr cost
            pq.poll();//remove from queue
            for(int i=0;i<dr.length;i++)
            {
                int newRow=row+dr[i];//going for four direvtion
                int newCol=col+dc[i];
                if(newRow<0||newCol<0||newRow>=heights.length||newCol>=heights[0].length)continue;
                int newCost=Math.max(Math.abs(heights[newRow][newCol]-heights[row][col]),cost);//finding new cost
                if(newCost<efforts[newRow][newCol])//if it is less than prev
                {
                  efforts[newRow][newCol]=newCost;//update
                  pq.add(new int[]{newRow,newCol,newCost});//add to pq 
                }
            }

        }
        return efforts[r-1][c-1];
    }
}
