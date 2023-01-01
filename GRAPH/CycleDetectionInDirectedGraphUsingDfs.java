//Cycle detection in directed graph using DFs
//TC-O(V+E)

package cycledetectionindirectedgraph;
import java.util.*;


public class CycleDetectionInDIrectedGraph {
    public static boolean Dfs(boolean visited[],List<List<Integer>> l,int curr)
    {
        if(visited[curr]==true)return true;//curr visiting node is already true it means there is an cycle
        visited[curr]=true;//making the curr visiting node to true
        for(int i=0;i<l.get(curr).size();i++)//traversing the curr node 
        {
            if(Dfs(visited,l,l.get(curr).get(i)))//Dfs call
            {
                return true;//if cycle found return true
            }
        }
        visited[curr]=false;//while return back(backtrack) to another path we need to make all the visited node to false;
        return false;//if no cycle is found from curr source node
    }

     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        int mat[][]=new int[][]{{0,1},{1,2},{1,3},{2,4},{2,3},{4,5},{5,2}};//input in matrix format
        int n=6;//vertex+1 for creating an boolean array adding 1;
        List<List<Integer> >l=new ArrayList<>();//creating 2dlist 
        for(int i=0;i<n;i++)
        {
            l.add(new ArrayList<>());//adding the list
        }
        for(int i=0;i<mat.length;i++)
        {
            l.get(mat[i][0]).add(mat[i][1]);//adding elemnts in the list
        }
        boolean visited[]=new boolean[n];//creating an visited array
        for(int i=0;i<n;i++)
        {
           
            if(Dfs(visited,l,i))//each time calling the Dfs method to check whether there is an cycle from curr node;
            {
                System.out.println("Cycle Detected");//if found
                System.exit(0);
            }
        }
        System.out.println("No Cycle Detected");//hence no cycle is founded for all the nodes 
       
    }
    
}
