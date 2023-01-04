//LC-547

class Solution {
    public boolean Dfs(List<List<Integer>> l,boolean []visited,int curr)
    {
        visited[curr]=true;
        for(int i=0;i<l.get(curr).size();i++)
        {
            if(visited[l.get(curr).get(i)]==false&&Dfs(l,visited,l.get(curr).get(i)))
            {
               
                return true;
            }
        }
        return false;
    }
    public int findCircleNum(int[][] m) {
       List<List<Integer>> l=new ArrayList<>();
       for(int i=0;i<=m.length;i++)
       {
           l.add(new ArrayList<>());

       } 
       for(int i=0;i<m.length;i++)
       {
           for(int j=0;j<m[0].length;j++)
           {
               if(m[i][j]==1)
               {
                   l.get(i+1).add(j+1);
               }
           }
       }
       int count=0;
       boolean visited[]=new boolean[m.length+1];
       for(int i=1;i<=m.length;i++)
       {
           if(visited[i]==false)
           {
                count++;
               Dfs(l,visited,i);
               
           }
          
       }
       return count;
    }
}
