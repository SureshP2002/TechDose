//lc-122
//approach-greedy


class Solution {
    public int maxProfit(int[] prices) {
        int max_Profit=0;
        //va;;ey peak approach
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])max_Profit+=prices[i]-prices[i-1];//wheneer the increasing order comes just add the diff
        }
        return max_Profit;
    }
}
