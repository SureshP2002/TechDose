//TC(V*V)


package dijkstraalgorithmshortpath;
import java.util.*;
public class DijkstraAlgorithmShortPath {
     
    public static int Min_Weigth_Node(boolean mstSET[],int distance[])
    {
        
        //finding the minimum index in distance array all the time
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<distance.length;i++)
        {
            if(mstSET[i]==false&&distance[i]<min)
            {
                min=distance[i];
                index=i;
            }
        }
        return index;
    }

     public static void Dijkshtra(int edges_weigth[][],int V)
    {
        int distance[]=new int[V];//creating distance array for storing the minimum distance each time
        boolean mstSET[]=new boolean[V];//creatig boolean array for avoid repeative calls
        int parent[]=new int[V];//creating an parent array storing parent
        Arrays.fill(distance, Integer.MAX_VALUE);//filling the distance array initially maxvalue
        distance[0]=0;//starting at 0
        parent[0]=-1;//parent for 0 is -1;always
        for(int i=0;i<V-1;i++)
        {
            int U=Min_Weigth_Node(mstSET,distance);//finding the min dis node ;
            mstSET[U]=true;//making it as true
            for(int j=0;j<V;j++)//traversing and check if node any adjacent is less than distance
            {
                if(edges_weigth[U][j]!=0&&mstSET[j]==false&&(edges_weigth[U][j]+distance[U])<distance[j])
                {
                    distance[j]=edges_weigth[U][j]+distance[U];//upating the distacne with curr dis
                    parent[j]=U;//and parent for that is curr minDisNode
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            System.out.println("u->v: "+parent[i]+" -> "+i+" wt= "+distance[i]);
        }
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int V=sc.nextInt();
       int edges_weigth[][]={{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
			    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			    { 0, 0, 2, 0, 0, 0, 6, 7, 0 }};//input matrix
      
       Dijkshtra(edges_weigth,V);
    }
    
}
