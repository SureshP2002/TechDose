//Dfs Traversal
//TC-O(V+E) Vertices+edges

package dfstraversal;
import java.util.*;


public class DFSTraversal {
     public static void DFS(List<List<Integer>> l,boolean visited[],int curr)
     {
         visited[curr]=true;//making curr visited arr as false
         System.out.print(curr+" ");//printing
         for(int i=0;i<l.get(curr).size();++i)//traversing  the curr
         {
             if(visited[l.get(curr).get(i)]==false)//if visisted array of curr is false
             {
                 visited[l.get(curr).get(i)]=true;//making it as true
                 DFS(l,visited,l.get(curr).get(i));//recursive call
             }
         }
     }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=8;
        int edges[][]=new int[][]{{0,1},{0,2},{0,3},{1,4},{2,5},{3,6},{4,7},{5,7},{6,7}};//input matrix form
        List<List<Integer>> l=new ArrayList<>();//decalring in 2d-List
        for(int i=0;i<n;i++)
        {
            l.add(new ArrayList<>());//creating list for n-1
        }
        for(int i=0;i<edges.length;i++)
        {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);//undirected case
        }
        boolean visited[]=new boolean[n];//creating visited array based on no of vertex n
        DFS(l,visited,0);
       
    }
    
}
