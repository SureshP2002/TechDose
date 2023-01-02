//TC-O(VE)

package bellmanfordalgorithm;
import java.util.*;


public class BellmanFordAlgorithm {

    public static void bellmenford(int [][]edges,int V)
    {
        int parent[]=new int[V];//for storing parent
        int distance[]=new int[V];//for storing the distnace
        Arrays.fill(distance, Integer.MAX_VALUE);
        parent[0]=-1;//initialyy parent of 0 is -1
        distance[0]=0;//initially distance from -1 to 0 is 0
        boolean updated=false;
        for(int i=0;i<V-1;i++)
        {
            updated=true;//make true to updated
            for(int j=0;j<edges.length;j++)//go for all the edges matrix and do dijkstra algo
            {
                int u=edges[j][0];
                int v=edges[j][1];
                int wt=edges[j][2];
                if(distance[u]!=Integer.MAX_VALUE&&distance[u]+wt<distance[v])//if curr disV greater than prev u dis+wt
                {
                    distance[v]=distance[u]+wt;
                    parent[v]=u;//update
                    updated=true;
                    
                }
            }
            if(updated==false)break;//if no update happens then shortest path finded and no negative edge cyclw
        }
        
        for(int j=0;j<edges.length&&updated==true;j++)//if updated is true then dis varues at each step
        {
                int u=edges[j][0];
                int v=edges[j][1];
                int wt=edges[j][2];
                if(distance[u]!=Integer.MAX_VALUE&&distance[u]+wt<distance[v])//if we check again value is decreasing then negative edge detected
                {
                    System.out.print("Cycle has negative edge cycle");
                    System.exit(0);
                }
        }
        for(int i=0;i<V;i++)//shortest path
        {
            System.out.println("u->v:"+parent[i]+"->"+i+"  cost to reach "+parent[i]+" from source 0 is:"+distance[i] );
        }
        
        
    }
        
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
       int V=6;
       int edges[][]=new int[][]{{0,1,4},{0,3,9},{1,2,-1},{2,5,3},{3,2,2},{3,4,-5},{4,5,0}};//input [u,v,wt]
       bellmenford(edges,V);
        
    }
    
}
