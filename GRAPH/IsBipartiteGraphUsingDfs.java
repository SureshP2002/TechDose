//TC-O(N)

package isbipartitegraphusingdfs;
import java.util.*;


public class IsBipartiteGraphUsingDfs {
      static int colors[];
      public static boolean check_bipar_Dfs(List<List<Integer>> l,int curr,int colour)
      {
          colors[curr]=colour;//making the curr color array to given colour
          for(int i=0;i<l.get(curr).size();i++)//traversing the arrsy
          {
              if(colors[l.get(curr).get(i)]==-1)//if adj node is -1 then it is not vsisted
              {
                  if(!check_bipar_Dfs(l,l.get(curr).get(i),1-colour))return false;//if adj has some same color
              }
              else if(colors[l.get(curr).get(i)]==colour)//if adj nods have same clolour
              {
                  return false;//not a bipartite
              }
          }
          return true;//if no adj with same colour then return true
      }
    public static boolean isBipartite(List<List<Integer>> l,int V)
    {
        for(int i=1;i<V;i++)//traversing the colors array
        {
            if(colors[i]==-1)//if color array is -1
            {
                if(check_bipar_Dfs(l,i,0)==false)//check for bipartite
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
        int mat[][]=new int[][]{{},{2},{1,3},{2}};//input matrix in list format
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
            System.out.println("Not a Bipartite Graph");//if not true
        }
    }
    
}
