//lc-1026
//approach-greedy

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));//sort based on difference;
        int ans=0;
        for(int i=0;i<costs.length;i++)
        {
            ans+=(i>=(costs.length/2)?costs[i][1]:costs[i][0]);
        }
        return ans;
    }
}
