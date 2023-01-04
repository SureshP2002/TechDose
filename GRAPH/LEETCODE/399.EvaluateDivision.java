//LC-399

class Solution {
    static double ans[];
    static boolean flag;
    static int index=0;
    public void Dfs(Map<String,List<Pair<String,Double>>> m,String curr,String destination,Set<String> visited,double val)
    {
         visited.add(curr);
        if(curr.equals(destination))
        {
            flag=true;
            ans[index++]=val;
            return ;
        }
       
        for(Pair<String,Double> p:m.get(curr))
        {
            String adj=p.getKey();
            double w=p.getValue();
            if(!visited.contains(adj))
            {
               Dfs(m,adj,destination,visited,val*w);
            }
        }
    }
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> q) {
       Map<String,List<Pair<String,Double>>> map=new HashMap<>();
       index=0;
       for(int i=0;i<eq.size();i++)
       {
           String u=eq.get(i).get(0);
           String v=eq.get(i).get(1);
           double w=values[index++];
           if(!map.containsKey(u))
           {
               map.put(u,new ArrayList<>());
           }
           if(!map.containsKey(v))
           {
               map.put(v,new ArrayList<>());
           }
           map.get(u).add(new Pair<>(v,w));
           map.get(v).add(new Pair<>(u,1/w));
       }
       index=0;
       ans=new double[q.size()];;
       for(int i=0;i<q.size();i++)
       {
           String src=q.get(i).get(0);
           String des=q.get(i).get(1);
           if(!map.containsKey(src)||!map.containsKey(des))
           {
               ans[index++]=-1.0;
           }
           else
           {
               flag=false;
               Dfs(map,src,des,new HashSet<>(),1);
               if(!flag)ans[index++]=-1.0;
           }
       }
       return ans;

    }
}
