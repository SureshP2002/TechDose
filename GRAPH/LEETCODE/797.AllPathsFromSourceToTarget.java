//LC-797

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    boolean vis[];
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    vis=new boolean[graph.length];//creting vis array
    Dfs(0,graph.length-1,new ArrayList<>(),graph,vis);//dfs call
    return ans;
    }
    public void Dfs(int curr,int des,List<Integer> a,int graph[][],boolean[] visited)
    {
       visited[curr]=true;//making visited true
       a.add(curr);//adding to list
       if(curr==des)//if destination comes
       {
           visited[curr]=false;//make false(backtrack)
           ans.add(new ArrayList<>(a));//add to list
           a.remove(Integer.valueOf(curr));//remove lastly added
           return;
       }
       
       for(int i=0;i<graph[curr].length;i++)
       {
           if(visited[graph[curr][i]]==false)//traversing for adj
           {
               Dfs(graph[curr][i],des,a,graph,visited);//dfs call
           }
       }
       visited[curr]=false;(backtrack)
       a.remove(a.size()-1);//remove lastly Added
       


    }
}
