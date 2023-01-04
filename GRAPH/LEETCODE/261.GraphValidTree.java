//LC-261

package checkgraphisatree;
import java.util.*;


public class CheckGraphIsATree {
   static boolean visited[];
    static  boolean Dfs(List<List<Integer>> l ,int V,int curr,int parent)
    {
        visited[curr]=true;
        for(int i=0;i<l.get(curr).size();i++)
        {
            if(visited[l.get(curr).get(i)]==false)
            {
                if(Dfs(l,V,l.get(curr).get(i),curr))
                {
                    return true;
                }
            }
            else if(l.get(curr).get(i)!=parent)return true;
        }
        return false;
        
    }
    public static boolean checkGraph(List<List<Integer>> l,int V)
    {
       int count=0;
       for(int i=0;i<V;i++)
       {
           if(visited[i]==false)
           {
               count++;
               if(Dfs(l,V,i,-1))return false;
           }
       }
       return count==1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int edges[][]=new int[][]{{0,1},{0,2},{0,3},{1,4}};
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);
        }
        visited=new boolean[V];
        if(checkGraph(l,V))
        {
            System.out.println("Given graph is a tree");
        }
        else
        {
            System.out.println("Given graph is not a tree");
        }
       
    }
    
}
