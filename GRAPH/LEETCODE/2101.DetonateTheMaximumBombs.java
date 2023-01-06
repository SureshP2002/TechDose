//lc-2101

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int max=0;
        for(int i=0;i<bombs.length;i++)
        {
            max=Math.max(max,MaxBfs(bombs,i,new boolean[bombs.length]));//each time call bfs and find max
        }
        return max;
    }
    public int MaxBfs(int [][]bombs,int source,boolean visited[])
    {
        Queue<Integer> q=new LinkedList<>();//creating queue
        visited[source]=true;//mking visited true
        q.add(source);//adding source
        int count=1;//initial count 1
        while(!q.isEmpty())
        {
            int curr=q.poll();//polling queue element
            for(int i=0;i<bombs.length;i++)//checking its adjacent
            {
                if(!visited[i]&&inRange(bombs[curr],bombs[i]))//checking if it is range
                {
                    visited[i]=true;//make adj visited
                    count++;
                   q.add(i);//ading to queue

                }
            }
        }
        return count;//return count
    }
    public static boolean inRange(int a[],int b[])
    {
       long x1=a[0],y1=a[1],x2=b[0],y2=b[1],d=a[2];//finding distance between two points d=√((x_2-x_1)²+(y_2-y_1)²)
       long dx=x1-x2,dy=y1-y2;
       return Math.sqrt((dx*dx)+(dy*dy))<=r;

    }
}
