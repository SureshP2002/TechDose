//TC-O(VLogE)

package dijkstraalgorithmusingpriorityqueue;
import java.util.*;

public class DijkStraALgorithmUsingPriorityQueue {

    public static void Dijkstra(PriorityQueue<int[]> pq,int edg[][],int V)
    {
        int distance[]=new int[V];//creating distance array
        boolean mstSet[]=new boolean[V];//avoid repeated visiting
        int parent[]=new int[V];//parent store
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        parent[0]=-1;
        pq.add(new int[]{0,0});//initialy adding j index an minindex and  distance j is 0;
        for(int i=0;i<V-1;i++)
        {

            int U=pq.remove()[0];//removing top(smallest)
            mstSet[U]=true;//making it as true
            for(int j=0;j<V;j++)//traversing for all edges
            {
                if(edg[U][j]!=0&&mstSet[j]==false&&edg[U][j]+distance[U]<distance[j])//check curr dis less that prev
                {
                    distance[j]=edg[U][j]+distance[U];//update
                    parent[j]=U;
                    pq.add(new int[]{j,distance[j]});//add in pq{j,d[j]};
                }
                
            }
            
        }
          for(int i=1;i<V;i++)
        {
            System.out.println("u->v: "+parent[i]+" -> "+i+" wt= "+distance[i]);//priting
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
      int edges_weigth[][]={{ 0, 9, 6, 5, 3, 0, 0, 8, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 2, 0, 4, 0, 0, 0, 0, 0 },
			    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };//input matrix
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);//creating priorityqueue for for finding shortest min index at step
        Dijkstra(pq,edges_weigth,edges_weigth.length);//function call
    }
}
