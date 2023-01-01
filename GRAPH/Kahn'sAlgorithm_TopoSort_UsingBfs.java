//TC_O(V+E)


package topologicalsortusingbfs;
import java.util.*;

public class TopologicalSortUsingBfs {
      public static void  topoSort_Using_Bfs(List<List<Integer>> l,Queue<Integer> q,int indegree[],int V)
      {
          List<Integer> ans=new ArrayList<>();//creating an list storing the value
          while(!q.isEmpty())
          {
              int curr=q.poll();//removing the first element
              ans.add(curr);//add the removed element to queue
              for(int i=0;i<l.get(curr).size();i++)
              {
                  if(--indegree[l.get(curr).get(i)]==0)//degrement the indegre for all adj nodes (
                  {
                      q.add(l.get(curr).get(i));//if indegree if 0 then add to queue
                  }
                  
              }
              
          }
          
          if(ans.size()==V)//if ans list size is not equal to V then the given graph is cyclic
          {
              System.out.println(ans);//printing list
          }
          else
          {
              System.out.print("It is An Cyclic Grapgh");//cycle
          }
      }
       public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           int V=sc.nextInt();
           int edges[][]=new int[][]{{},{},{3},{1},{0,1},{2,0}};//input matrix
           List<List<Integer>> l=new ArrayList<>();//creatin 2d list
           int indegree[]=new int[V];//creting an array for finding the indegree of each node
           for(int i=0;i<V;i++)
           {
               l.add(new ArrayList<>());//adding list
           }
           for(int i=0;i<edges.length;i++)
           {
               for(int j=0;j<edges[i].length;j++)
               {
                   l.get(i).add(edges[i][j]);//adding elements
                   indegree[l.get(i).get(j)]++;//increamenting the indegree hash
               }
               
           }
           Queue<Integer> q=new LinkedList<>();//creating an queue
           for(int i=0;i<V;i++)
           {
             if(indegree[i]==0)//if indegree of node is 0 add to queue
             {
                 q.add(i);
             }
           }
           topoSort_Using_Bfs(l,q,indegree,V);//function call
               
           
           
        
    }
    
}
