//lc-1578
//approach-greedy


class Solution {
    public int minCost(String s, int[] cost) {
        int res=0,sum_cost=0,max_cost=0,n=s.length();
       for(int i=0;i<n;i++)
       {
           if(i>0&&s.charAt(i-1)!=s.charAt(i))//if not equal means find minimum to be deleted
           {
               res+=sum_cost-max_cost;
               sum_cost=max_cost=0;
           }
           sum_cost+=cost[i];//add
           max_cost=Math.max(max_cost,cost[i]);
           
       }
       res+=sum_cost-max_cost;//for last sequence of same balloons
       return res;
        

    }
}
