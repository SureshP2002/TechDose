//leetcode-121 
//TC -O(n);


class Solution {
    public int maxProfit(int[] p) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<p.length;i++)
        {
            min=Math.min(p[i],min);
            max=Math.max(p[i]-min,max);
            
        }
        return max;
        
    }
}
