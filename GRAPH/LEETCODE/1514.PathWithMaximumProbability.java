//LC-1514

class Solution {
    static double bfs(List<List<Pair<Integer,Double>>> l,PriorityQueue<Pair<Integer,Double>> pq,int start,int end,int V)
    {
      double distance[]=new double[V];
      distance[start]=1.0;
      pq.add(new Pair<>(start,1.0));
      while(!pq.isEmpty())
      {
          Pair<Integer,Double> p=pq.poll();
          int u=p.getKey();
          double cost=p.getValue();
          if(u==end)break;
          for(Pair<Integer,Double> pair:l.get(u))
          {
              int v=pair.getKey();
              double adjcost=pair.getValue();
              if(cost*adjcost>distance[v])
              {
                  distance[v]=cost*adjcost;
                  pq.add(new Pair<>(v,distance[v]));
              }
          }
      }
      return distance[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
       List<List<Pair<Integer,Double>>> l=new ArrayList<>();
       for(int i=0;i<=n;i++)
       {
           l.add(new ArrayList<>());
       } 
       int index=0;
       for(int[] i:edges)
       {
           l.get(i[0]).add(new Pair<>(i[1],succProb[index]));
           l.get(i[1]).add(new Pair<>(i[0],succProb[index++]));

       }
       PriorityQueue<Pair<Integer,Double>> pq=new PriorityQueue<>((p1,p2)->{
           if(p1.getValue()>p2.getValue())return -1;
           else if(p1.getValue()<p2.getValue())return 1;
           return 0;

       });
       return bfs(l,pq,start,end, n+1);
    }
}
