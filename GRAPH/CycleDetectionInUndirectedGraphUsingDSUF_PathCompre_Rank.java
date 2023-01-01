//O(logN)



package cycledetectionbydsufbypathcompressionandrank;
import java.util.*;

 class node{
    int parent;
    int rank;
    node(int p,int r)
    {
        this.parent=p;
        this.rank=r;
                
    }
}
public class CycleDetectionByDsufByPathCompressionAndRank {
    public static node dsuf[];
   public static int find_By_Path_Compression(int V)
   {
       if(dsuf[V].parent==-1)//if curr parent is -1 then AbsParent is found 
       {
           return V;
       }                                                            //optimized
       return dsuf[V].parent=find_By_Path_Compression(dsuf[V].parent);//else recursive call to Abs Parent and store the result in dsuf[v] 
   }
   public static void union_By_Rank(int fromP,int toP)
   {
       if(dsuf[fromP].rank==dsuf[toP].rank)//if  both the rank is same means we can add any (fromP to toP)or(toP to fromP)
       {
           dsuf[fromP].parent=toP;//joining fromP to toP
           dsuf[toP].rank+=1;//and incresing the rank for toP beacuse height will increase when we join them
       }
       else if(dsuf[fromP].rank<dsuf[toP].rank)//if fromP rank is less than toP
       {
           dsuf[fromP].parent=toP;//join fromP to toP because adding smaller rank to larger rank will give the same rank of the tree
       }
       else if(dsuf[toP].rank<dsuf[fromP].rank)//if toP rank is less than the fromP
       {
           dsuf[toP].parent=fromP;//join toP to fromP
       }
   }
    public static boolean CycleFound(int edges[][],int E)
    {
        for(int i=0;i<E;i++)
        {
            int fromP=find_By_Path_Compression(edges[i][0]);//finding the Absolute parent for from
            int toP=find_By_Path_Compression(edges[i][1]);//finding the Absolute parent for to
            if(fromP==toP)//if bOth are equal means there is an cycle because ther are already in the same graph
            {
                return true;
            }
            else{
            union_By_Rank(fromP,toP);//else combine them in one set
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt();//no of Edges
        int V=sc.nextInt();//no of Vertices
        int edges[][]=new int[][]{{0,1},{2,3},{1,2},{0,4},{4,3}};//creating an edge matrix
        dsuf=new node[V];//declaring the node for the given vertices vertex
        for(int i=0;i<V;i++)
        {
            dsuf[i]=new node(-1,0);//each node contains the parent(-1) and rank(0)
        }
        if(CycleFound(edges,E))//if cycle is found
        {
            System.out.println("Cycle is Found");
        }
        else //if not found
        {
            System.out.println("Cycle is not found");
        }
    }
