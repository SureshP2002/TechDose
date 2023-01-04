//LC-210


class Solution {
       
    public int[] findOrder(int n, int[][] edges) {
           int V=n;
           List<List<Integer>> l=new ArrayList<>();//creatin 2d list
           int indegree[]=new int[V];//creting an array for finding the indegree of each node
           for(int i=0;i<V;i++)
           {
               l.add(new ArrayList<>());//adding list
           }
           for(int i=0;i<edges.length;i++)
           {
               
                   l.get(edges[i][1]).add(edges[i][0]);//adding element
            }
           for(int i=0;i<V;i++)
           {
               for(int j=0;j<l.get(i).size();j++)
               {
                   indegree[l.get(i).get(j)]++;
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
          int arr[]=new int[n],ind=0;
          while(!q.isEmpty())
          {
              int curr=q.poll();//removing the first element
              arr[ind++]=curr;
              for(int i=0;i<l.get(curr).size();i++)
              {
                  if(--indegree[l.get(curr).get(i)]==0)//deg]crement the indegre for all adj nodes 
                  {
                      q.add(l.get(curr).get(i));//if indegree, if 0 then add to queue
                  }
              }
          }
          
          if(ind==n)return arr;
          return new int[]{};
    }
}
