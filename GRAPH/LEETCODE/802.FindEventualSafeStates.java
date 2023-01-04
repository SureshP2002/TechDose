//lc-802

class Solution {
    static int visited[];
    public static boolean Dfs(List<List<Integer>> l,int curr)
    {
        if(visited[curr]==2)return true;//if already visited and processed and there is no path means
        if(visited[curr]==1)return false;//if curr node visiting in curr path again this forms a cycle
        visited[curr]=1;//visiting path
        for(int i=0;i<l.get(curr).size();i++)
        {
            if(!Dfs(l,l.get(curr).get(i)))
            {
                return false;
            }
        }
        visited[curr]=2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> l=new ArrayList<>();
        int V=graph.length;
        for(int i=0;i<graph.length;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                l.get(i).add(graph[i][j]);
            }
        }
        visited=new int[V];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(Dfs(l,i))
            {
              ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
