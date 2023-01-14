//LC-2246

class Solution {
    int max=1;
    int dist[]=new int[100000];
    public void Dfs(List<List<Integer>> l,int src,String s)
    {
        
         
         dist[src]=1;//making curr src as one
         for(int adj=0;adj<l.get(src).size();adj++)
         {
          Dfs(l,l.get(src).get(adj),s);//dfs call untill it reaches the bottom of tree
          if(s.charAt(src)!=s.charAt(l.get(src).get(adj)))//once it reaches the bootom it starts checking parent and adj char are equal are not
          {
              max=Math.max(max,dist[src]+dist[l.get(src).get(adj)]);//finding max of src to adj
              dist[src]=Math.max(dist[src],dist[l.get(src).get(adj)]+1);//update src if two char not equal then the parent's(longest path increases)
          }
         }

    }
    public int longestPath(int[] parent, String s) {
        int V=parent.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            l.add(new ArrayList<>());//creating 2d list
        }
        for(int i=1;i<parent.length;i++)
        {
            l.get(parent[i]).add(i);//adding connection 
            
        }
        
       Dfs(l,0,s);
       return max;
    }
}
