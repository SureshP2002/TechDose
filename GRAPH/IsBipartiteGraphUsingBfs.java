//TC-O(V*V)

package isbipartitegraphusingbfs;
import java.util.*;


public class IsBipartiteGraphUsingBfs {
     static int colors[];
     public static boolean check_bipar_bfs(List<List<Integer>> l,int source)
     {
         Queue<Integer> q=new LinkedList<>();//creting an Queue
         q.add(source);//adding the source elemnt
         colors[source]=0;//making the source color to 0
         while(!q.isEmpty())
         {
             int curr=q.poll();//remove first entered
             for(int i=0;i<l.get(curr).size();i++)//traversing current
             {
                 int adj=l.get(curr).get(i);
                 if(colors[adj]==-1)//if adjacent of current is -1 it means it is not visited
                 {
                     colors[adj]=1-colors[curr];//make it opposite color
                     q.add(adj);//add it queue
                 }
                 else if(colors[adj]==colors[curr])//if adj color is equal to curr color then bipartite is not possible
                 {
                     return false;//retunr false;
                 }
             }
         }
         return true;//finally if possible
     }
    public static boolean isBipartite(List<List<Integer>> l,int V)
    {
        for(int i=1;i<V;i++)//traversing the colors array
        {
            if(colors[i]==-1)//if color array is -1
            {
                if(check_bipar_bfs(l,i)==false)//check for bipartite
                {
                    return false;//if not
                }
            }
        }
        return true;//finaly after completing all nodes it will return true
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();//getting the vertices
        int mat[][]=new int[][]{{},{2},{1,3,6},{2,4},{3,5,7},{4,6},{2,5},{4,8},{7}};//input matrix in list format
        List<List<Integer>> l=new ArrayList<>();//declaring the 2d list
        for(int i=0;i<V;i++)
        {
            l.add(new ArrayList<>());//adding list inside l for V size
        }
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                l.get(i).add(mat[i][j]);//adding elemenst is list
            }
        }
        colors=new int[V];//declaring the colors array size vertex size
        Arrays.fill(colors,-1);//filling the array with -1 initialy
        if(isBipartite(l,V))//checking for bipartite
        {
            System.out.println("It is an Bipartite Graph");//if true
        }
        else
        {
            System.out.println("Not a Bipartite Graph");//if not
        }
        
    }
    
}
