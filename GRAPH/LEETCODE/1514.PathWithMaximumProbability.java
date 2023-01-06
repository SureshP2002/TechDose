//LC-1514

class Solution {
    static double bfs(List<List<Pair<Integer,Double>>> l,PriorityQueue<Pair<Integer,Double>> pq,int start,int end,int V)
    {
      double distance[]=new double[V];//creating distance array
      distance[start]=1.0;//initial distance is 1
      pq.add(new Pair<>(start,1.0));//adding start and its distance is 1.0
      while(!pq.isEmpty())
      {
          Pair<Integer,Double> p=pq.poll();//taking top
          int u=p.getKey();//getting u
          double cost=p.getValue();//cost
          if(u==end)break;//if u reaches destination break;
          for(Pair<Integer,Double> pair:l.get(u))//traverse all its adjacent
          {
              int v=pair.getKey();//get adjind
              double adjcost=pair.getValue();//get adjcost
              if(cost*adjcost>distance[v])//if curr pro >prev prob
              {
                  distance[v]=cost*adjcost;//update
                  pq.add(new Pair<>(v,distance[v]));
              }
          }
      }
      return distance[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
       List<List<Pair<Integer,Double>>> l=new ArrayList<>();//creating the list with pair
       for(int i=0;i<=n;i++)
       {
           l.add(new ArrayList<>());//adding list
       } 
       int index=0;
       for(int[] i:edges)
       {
           l.get(i[0]).add(new Pair<>(i[1],succProb[index]));//adding edges and its weigth
           l.get(i[1]).add(new Pair<>(i[0],succProb[index++]));

       }
       PriorityQueue<Pair<Integer,Double>> pq=new PriorityQueue<>((p1,p2)->{//creating PirorityQueue
           if(p1.getValue()>p2.getValue())return -1;
           else if(p1.getValue()<p2.getValue())return 1;
           return 0;

       });
       return bfs(l,pq,start,end, n+1);//bfs call
    }
}
