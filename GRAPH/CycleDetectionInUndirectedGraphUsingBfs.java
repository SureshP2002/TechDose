//cycle detect in undirected grapgh using bfs
//TC-O(N+2E)

package cycledetectioninundiredtedgraphusingbfs;
import java.util.*;

public  class CycleDetectionInUndiredtedGraphUsingBfs {

    public  static boolean bfs(boolean visited[],List<List<Integer>> l,int source)
    {
        visited[source]=true;//making current visited source to true
        Queue<int[]> q=new LinkedList<>();//creating an Queue with array
        q.add(new int[]{source,-1});//adding adj and par
        while(!q.isEmpty())
        {
            int arr[]=q.poll();
            int adj=arr[0];//taking adj;
            int par=arr[1];//taking parent
            for(int cur=0;cur<l.get(adj).size();cur++)//traversing the adj noe fully
            {
                if(visited[l.get(adj).get(cur)]==false)//if curr is false
                {
                    visited[l.get(adj).get(cur)]=true;//make it true
                    q.add(new int[]{l.get(adj).get(cur),adj});//add it to queue with curr node and its parent
                    
                }
                else if(l.get(adj).get(cur)!=par)//else if curr node not equal to par and it already true
                {
                    return true;//found
                }
            }
            
        }
        return false;//there is no cycle
        
    }
    
    public static void main(String[] args) {
        int mat[][]=new int[][]{{},{2,3},{1,4},{1},{2},{6},{5},{8,9},{7,9},{8,7}};//input in matrix format(1 indexing)
        int n=11;//vertex +1;
        List<List<Integer>> l=new ArrayList<>();//creating an 2d list
        for(int i=0;i<n;i++)
        {
            l.add(new ArrayList<>());//adding list
        }
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                l.get(i).add(mat[i][j]);//adding the elements
            }
        }
        boolean visited[]=new boolean[n];//creating the boolean visited array
        
        for(int i=1;i<n;i++)//for multiple graph inputs
        {
            if(!visited[i])//if visited of curr is not true
            {
                if(bfs(visited,l,i))//bfs call
                {
                    System.out.println("Cycle Detected");//if cycle is found
                    System.exit(0);
                }
            }
        }
        System.out.println("Cycle Not Detected");//hence no path gives the cycle
    }
    
}
