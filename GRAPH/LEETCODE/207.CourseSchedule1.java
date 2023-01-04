//LC-207
class Solution {
   public boolean canFinish(int n, int[][] edges) {
        int V=n;
        List<List<Integer>> l=new ArrayList<>();//creating an 2d list
        for(int i=0;i<V;i++)
        {
            l.add(new ArrayList<>());//adding list inside them
        }
        int indegree[]=new int[V];
        for(int i=0;i<edges.length;i++){
           
                l.get(edges[i][0]).add(edges[i][1]);//adding elemnst in the list
        }
        for(int i=0;i<V;i++)
        {
            for(int j:l.get(i))indegree[j]++;
        }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<indegree.length;i++)
       {
           if(indegree[i]==0)
           {
               q.add(i);
           }
       }
       int ans=0;
       while(!q.isEmpty())
       {
           int curr=q.poll();
           for(int i=0;i<l.get(curr).size();i++)
           {
               if(--indegree[l.get(curr).get(i)]==0)q.add(l.get(curr).get(i));
           }
           ans++;
       }
       return ans==V;
      
    }
}
