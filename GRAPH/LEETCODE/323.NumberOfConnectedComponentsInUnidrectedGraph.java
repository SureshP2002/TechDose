//LC-323

package connectedcomponentsinundirectedgraph;
import java.util.*;

public class ConnectedComponentsinUndirectedGraph {

    public static void DFS(List<List<Integer>> l,boolean visited[],int curr)
     {
         visited[curr]=true;//making curr visited arr as false
         System.out.print(curr+" ");//printing
         for(int i=0;i<l.get(curr).size();++i)//traversing  the curr
         {
             if(visited[l.get(curr).get(i)]==false)//if visisted array of curr is false
             {
                 
                 DFS(l,visited,l.get(curr).get(i));//recursive call
             }
         }
     }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int V=5;
        int edges[][]=new int[][]{{0,1},{2,1},{3,4}};
        List<List<Integer>> l=new ArrayList<>();//decalring in 2d-List
        for(int i=0;i<V;i++)
        {
            l.add(new ArrayList<>());//creating list for n-1
        }
        for(int i=0;i<edges.length;i++)
        {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);//undirected case
        }
        boolean visited[]=new boolean[V];//creating visited array based on no of vertex n
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)//checking if visited is false;
            {
             DFS(l,visited,i);
             System.out.println();
            }
        }
    }
    
}
