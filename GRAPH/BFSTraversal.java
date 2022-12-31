//Bfs traversal
//TC-O(V-E)Vertices + Edges


package bfstraversal;
import java.util.*;


public class BFSTraversal {

    static void BFS(List<List<Integer>> l,boolean visited[],int source)
    {
       visited[source]=true;//making the array as true
       Queue<Integer> q=new LinkedList<>();//creating a queue
       q.add(source);//adding the source into the queue
     
       while(!q.isEmpty())
       {
            int curr=q.poll();//polling the first element from the queue
            System.out.print(curr+" ");
            for(int i=0;i<l.get(curr).size();i++)//traversing the curr branch
            {
                if(visited[l.get(curr).get(i)]==false)//if curr visited is false;
                {
                    visited[l.get(curr).get(i)]=true;//making them as true
                    q.add(l.get(curr).get(i));//recursive call
                }
            }
       }
       
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=8;
        int edges[][]=new int[][]{{0,1},{0,2},{0,3},{1,4},{2,5},{3,6},{4,7},{5,7},{6,7}};//input matrix
        List<List<Integer>> l=new ArrayList<>();//declaring an ArrayList<>()
        for(int i=0;i<n;i++)
        {
            l.add(new ArrayList<>());//creting list for size n-1
        }
        for(int i=0;i<edges.length;i++)
        {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);//undirected case
        }
        boolean visited[]=new boolean[n];//creting an visited array for size n
        BFS(l,visited,0);//BFS call
        
    }
    
}
