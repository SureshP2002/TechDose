//LC-785

class Solution {
    int visited[];
    public boolean Dfs(List<List<Integer>> l,int V,int curr,int color)
    {
        visited[curr]=color;//making visited to given colour
        for(int i=0;i<l.get(curr).size();i++)
        {
            if(visited[l.get(curr).get(i)]==-1)//if adj in -1 then go for Dfs
            {
                 if(!Dfs(l,V,l.get(curr).get(i),1-color))return false;//if adj color same means then here comes the false
            }
            else if(visited[l.get(curr).get(i)]==color)return false;//if both curr and adj color is same 
        }
        return true;//else all  are diff
    }
    public boolean Find(List<List<Integer>> l,int V)
    {
        for(int i=0;i<V;i++)
        {
            if(visited[i]==-1)//if visited is -1 then go for dfs
            {
                if(Dfs(l,V,i,0)==false)return false;//if no bipartite
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            l.add(new ArrayList<>());//creating the list
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                l.get(i).add(graph[i][j]);//adding the elements
            }
        }
        visited=new int[V];//creating the visited array
        Arrays.fill(visited,-1);//initial -1;
        return Find(l,V);

    }
}
