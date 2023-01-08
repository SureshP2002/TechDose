//LIS

class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS[]=new int[nums.length];
         int max=1;
        Arrays.fill(LIS,1);
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i]&&LIS[j]>=LIS[i])
                {
                    ++LIS[i];
                     max=Math.max(max,LIS[i]);
                }
            }
        }
       

        return max;

    }
}
