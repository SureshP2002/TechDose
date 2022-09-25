//leetcode-209
//TC-O(n)
//minimum size subArray sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int res=0;
        int min=Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            sum+=nums[right];
            if(sum>=target)
            {
                while(sum>=target)
                {
                    sum-=nums[left++];
                }
                min=Math.min(min,(right-left+1)+1);
            }
            
            
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
