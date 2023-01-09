//TC-O(ElogE+VlogE)

package kruskalsalgorithmusingdsuf;
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
public class KruskalsAlgorithmUsingDsuf {
     static node dsuf[];
     public static int find(int V)
     {
         if(dsuf[V].parent==-1)return V;//if curr parent is -1 the absolute parent is found
         return dsuf[V].parent=find(dsuf[V].parent);//recursive call
     }
     public static void union(int fromP,int toP)
     {
         if(dsuf[fromP].rank==dsuf[toP].rank)//if both ranj same
         {
             dsuf[fromP].parent=toP;//add (formp to toP) or (toP to fromp)
             dsuf[toP].rank+=1;//increase rank
         }
         else if(dsuf[fromP].rank<dsuf[toP].rank)//if from ran is low add to Top
         {
             dsuf[fromP].parent=toP;
         }
         else if(dsuf[toP].rank<dsuf[fromP].rank)//if toP rank is low to fromP
         {
             dsuf[toP].parent=fromP;
         }
     }
     public static void kruskals(int edges[][],int V,int E)
     {
         int minWeigth=0;
         List<int[]> l=new ArrayList<>();
         for(int i=0,j=0;i<E&&j<V-1;i++)
         {
             int fromP=find(edges[i][0]);//finding abs parent for(from)
             int toP=find(edges[i][1]);//findinf abs parent fro(to)
             if(fromP==toP)continue;//if both are same then there is cycle which means it not contribute to minimu path
             if(fromP!=toP)//if not same
             {
                 j++;
                 union(fromP,toP);//merge them
                 l.add(new int[]{edges[i][0],edges[i][1],edges[i][2]});//add to list
                 minWeigth+=edges[i][2];
             }
         }
       for(int i=0;i<l.size();i++)
       {
           System.out.println("u->v:"+l.get(i)[0]+"->"+l.get(i)[1]+"W="+l.get(i)[2]);
       }
       System.out.println("MStWeigth:"+minWeigth);
         
         
     }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        int edges[][]={{0,1,4},{0,2,6},{1,4,4},{1,2,6},{1,3,3},{2,3,1},{4,3,2},{4,5,7},{3,5,3}};//edges matrix with weigth
        
        dsuf=new node[V];//declaring node of size v
        for(int i=0;i<V;i++)
        {
            dsuf[i]=new node(-1,0);//initaila rank is 0 and parent is -1;
        }
        Arrays.sort(edges,(a,b)->a[2]-b[2]);//sorting based on the weigths
        kruskals(edges,V,E);
       
    }
    
}
