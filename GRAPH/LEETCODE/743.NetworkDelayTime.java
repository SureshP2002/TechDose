//LC-743


class Solution {
    static int cost;
    public int Bfs(List<List<Pair<Integer,Integer>>> l,int V,int k)
    {
        cost=0;
        int distance[]=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(k);
        while(!q.isEmpty())
        {
          int u=q.poll();
          for(Pair<Integer,Integer> p:l.get(u))
          {
              int v=p.getKey();
              int weigth=p.getValue();
              if(distance[u]+weigth<distance[v])
              {
                  distance[v]=distance[u]+weigth;
                  q.add(v);
              }
          }
        }
          for(int i=1;i<V;i++)
          {
              if(distance[i]==Integer.MAX_VALUE)return -1;
              cost=Math.max(cost,distance[i]);
          }
          return cost;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer,Integer>>> l=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int[] i:times)
        {
            l.get(i[0]).add(new Pair<>(i[1],i[2]));
        }
       return Bfs(l,n+1,k);
        
    }
}
