//TC-O(V+E)

package cycledetectionindirectedgraphusingdfs_3_color;
import java.util.*;


public class CycleDetectionInDirectedGraphUsingDfs_3_color {
    static int visited[];
    public static boolean Dfs(List<List<Integer>> l,int curr)
    {
        if(visited[curr]==2)return false;//if already processed and no path found
        if(visited[curr]==1)return true;//if it is curr processing path
        visited[curr]=1;//make as procesing
        for(int i=0;i<l.get(curr).size();i++)
        {
            if(Dfs(l,l.get(curr).get(i)))//if path found
            {
                return true;
            }
        }
        visited[curr]=2;//finaly if path from curr node make as processed 2
        return false;//no path
    }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int mat[][]=new int[][]{{0,1},{0,2},{1,2},{2,0},{2,3},{3,3}};//input in matrix format
        int n=6;//vertex+1 for creating an int visited array adding 1;
        List<List<Integer> >l=new ArrayList<>();//creating 2dlist 
        for(int i=0;i<n;i++)
        {
            l.add(new ArrayList<>());//adding the list
        }
        for(int i=0;i<mat.length;i++)
        {
            l.get(mat[i][0]).add(mat[i][1]);//adding elemnts in the list
        }
         visited=new int[n];//creating an visited array
        for(int i=0;i<n;i++)
        {
           
            if(Dfs(l,i))//each time calling the Dfs method to check whether there is an cycle from curr node;
            {
                System.out.println("Cycle Detected");//if found
                System.exit(0);
            }
        }
        System.out.println("No Cycle Detected");//hence no cycle is founded for all the nodes 
        
    }
    
}
