//LC-1584

class Solution {
    public int minCostConnectPoints(int[][] points) {
          int n=points.length,cost=0;
        int distance[]=new int[n];//creating the distance array
        boolean visited[]=new boolean[n];//and boolean array
        Arrays.fill(distance,Integer.MAX_VALUE);//initialy filling it with integer max
        List<int[]> l=new ArrayList<>();//creating list
        for(int []adj:points)
        {
            l.add(new int[]{adj[0],adj[1]});//adding the edges
        }
        int vertex=0;
        while(vertex!=-1)
        {
            int x1=l.get(vertex)[0];//getting curr index
            int y1=l.get(vertex)[1];
            visited[vertex]=true;//making true
            for(int i=0;i<n;i++)
            {
                int x2=l.get(i)[0];//getting adj index
                int y2=l.get(i)[1];
                int dis=Math.abs(x1-x2)+Math.abs(y1-y2);//finding distance
                if(visited[i]==false&&dis<distance[i])//if it is less than prev update
                {
                    distance[i]=dis;
                }
            }
            int mindis=Integer.MAX_VALUE,mindisVertex=-1;//finding mindis and minIndex
            for(int i=0;i<n;i++)
            {
                if(visited[i]==false&&distance[i]<mindis)
                {
                    mindis=distance[i];
                    mindisVertex=i;
                }
            }
            if(mindis!=Integer.MAX_VALUE)
            {
                cost+=mindis;//add mincost
            }
            vertex=mindisVertex;//mincostIndex
        }
        return cost;
    }
}
