//leetcode-121
//TC-O(n)


class Solution {
    public int maxProfit(int[] p) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<p.length;i++)
        {
            min=Math.min(p[i],min);//finding the minimum price on one day
            max=Math.max(p[i]-min,max);//finding maximu profit by subtracting minPrice to curr sell stock
        }
        return max;
        
    }
}
