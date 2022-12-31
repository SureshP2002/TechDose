//cycle detect in undirected grapgh using DSUF
//TC-O(E+V)


package cycledetectioninundirectedgraphusingdsuf;
import java.util.*;


public class CycleDetectionInUndirectedGraphUsingDSUF {
    public static int dsuf[];//declaring dsuf array
    public static int find(int v)
    {
        if(dsuf[v]==-1)//if curent dsuf[v] is -1 then it is the absolute parent
        {
            return v;//return current v then;
        }
        return find(dsuf[v]);//recursive call to find the absolute parent;
    }
    public static void union(int fromAbsParent,int toAbsParent)
    {
        dsuf[fromAbsParent]=toAbsParent;
    }
    public static boolean CycleFound(int mat[][],int E){
        for(int i=0;i<E;i++)//traversing the edge matrix
        {
            int fromAbsParent=find(mat[i][0]);//we need to find mat[i][0]-->from's absolute parent
            int toAbsParent=find(mat[i][1]);//                  mat[i][1]-->to's absolute parent
            if(fromAbsParent==toAbsParent)//if both the abs parent are same then they are in same it which indicates 
            {                          //there is already an path between the hence we connect these two that forms cycle
                return true;//hence return true
            }
            union(fromAbsParent,toAbsParent);//if there is no cycle the merge them 
        }
        return false;
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt();//no of edges-->4
        int v=sc.nextInt();//no of vertex v-1--->4-1=
        dsuf=new int[v];//creating dsuf array to find the cycle
        Arrays.fill(dsuf,-1);//initially filling the dsuf Array With -1
        int edges[][]=new int[][]{{0,1},{0,3},{2,3},{1,2}};//input matrix----->undirected grapgh
        if(CycleFound(edges,E))//function call to find whether there is an cycl or not
        {
            System.out.println("Cycle Detected");//if found
        }
        else 
        {
            System.out.println("Cycle  not Detected");//if not found
        }
    }
    
}
