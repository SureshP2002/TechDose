//cycle detect in undirected graph using Dfs
//TC-O(N+2E)

package cycledetectioninundirectedgraphusingdfs;
import java.util.*;


public class CycleDetectionInUndirectedGraphUsingDfs {

    public static boolean Dfs(List<List<Integer>> l,int curr,int parent,boolean visited[])
    {
        visited[curr]=true;//making curr node visited array to treu
        for(int i=0;i<l.get(curr).size();i++)//tarversing the curr node adjacent
        {
            if(visited[l.get(curr).get(i)]==false)//if visited of adjacent is false
            {
                if(Dfs(l,l.get(curr).get(i),curr,visited))//then Dfs call
                return true;//if cycle found
            }
            else if(l.get(curr).get(i)!=parent)//if adjacent is true and it is not equal to parent
            {
                return true;//cycle found
            }
        }
        return false;//if no cycle found
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//no fo vertices+1
        int edges[][]=new int[][]{{},{2,3},{1,5},{1,4,6},{3},{2,7},{3,7},{5,6}};//edges matrix int list form-->1 indexing
        List<List<Integer>> l=new ArrayList<>();//declaring an list
        for(int i=0;i<n;i++)
        {
            l.add(new ArrayList<>());//creating list for the vertices
        }
        for(int i=0;i<edges.length;i++)
        {
            for(int j=0;j<edges[i].length;j++)
            {
                l.get(i).add(edges[i][j]);//adding elemenst in list
            }
        }
        boolean visited[]=new boolean[n];//creating visited array
        for(int i=1;i<n;i++)//traversing from in 1--->1 indexing
        {
            if(visited[i]==false)//if visited if false
            {
                if(Dfs(l,i,-1,visited))//Dfs
                {
                    System.out.println("Cycle Dtected");//if cycle found
                    System.exit(0);
                }
            }
        }
        System.out.println("Cycle Not Detected");//if cycle not found
        
    }
    
}
