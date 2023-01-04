//LC-886

class Solution {
    public boolean isBipirate(List<List<Integer>> l,int colour[],int source)
    {
        colour[source]=1;//puting the color
        Queue<Integer> q=new LinkedList<>();//creating the queue
        q.add(source);//adding curr
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(int i=0;i<l.get(curr).size();i++)//travresing for adj
            {
                
               if(colour[l.get(curr).get(i)]==-1)//if adj color is -1 then it is not coloured
               {
                   colour[l.get(curr).get(i)]=1-colour[curr];//make color opp to curr colour
                   q.add(l.get(curr).get(i));
               }
               else if(colour[curr]==colour[l.get(curr).get(i)])return false;//else check if curr and adj color are smae and return false
            }
        }
        return true;//finally it is possible

    }
    public boolean possibleBipartition(int p, int[][] d) {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=p;i++)
        {
            l.add(new ArrayList<>());//creatig the list
        }
        for(int[] con:d){
            l.get(con[0]).add(con[1]);
            l.get(con[1]).add(con[0]);//adding the elements
        }
        int colour[]=new int[p+1];//creating the color array 
        Arrays.fill(colour,-1);//making initially all values as -1
        for(int i=1;i<=p;i++)
        {
            if(colour[i]==-1)//if color is -1 then it is not visited
            {
                if(!isBipirate(l,colour,i))return false;//if adj are diff colour return false
            }
        }
        return true;//it is possible to split

    }
}
