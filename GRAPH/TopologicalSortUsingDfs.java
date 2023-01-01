//TC-O(V+E)

package topologicalsortusingdfs;
import java.util.*;


public class TopologicalSortUsingDfs {
   static int visited[];
   public static void Dfs(List<List<Integer>> l,Stack<Integer> st,int curr)
   {
       visited[curr]=1;//making 1 visited
       for(int i=0;i<l.get(curr).size();i++)
       {
           if(visited[l.get(curr).get(i)]==0)//checking adj 0 and if 0 do dfs
           {
             Dfs(l,st,l.get(curr).get(i));
           }
       }
       
       st.push(curr);//once there is no path push into stack
   }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();//vertex
        int edges[][]=new int[][]{{},{},{3},{1},{0,1},{0,2}};//matrix
        Stack<Integer> st=new Stack<>();//creating an stack
        List<List<Integer>> l=new ArrayList<>();//creating an 2d list
        for(int i=0;i<edges.length;i++)
        {
            l.add(new ArrayList<>());//adding list inside them
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length;j++){
                l.get(i).add(edges[i][j]);//adding elemnst in the list
            }
        }
        visited=new int[V];//creating an visited array
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)//if visited is 0 the do dfs
            {
                Dfs(l,st,i);
            }
        }
        while(!st.isEmpty())//pop elemenst from the stack and print
        {
            System.out.print(st.pop()+" ");
            
        }
    }
    
}
