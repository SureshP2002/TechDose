//LIS

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int LIS[]=new int[nums.length];
        int count[]=new int[nums.length];
        Arrays.fill(LIS,1);
        Arrays.fill(count,1);
        int max=1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
               if(nums[j]<nums[i])
               {
                   if(LIS[j]>=LIS[i])
                   {
                       ++LIS[i];
                       count[i]=count[j];
                   }
                   else if(LIS[j]+1==LIS[i])
                   {
                       count[i]+=count[j];
                   }
               }
               
            }
            max=Math.max(max,LIS[i]);
        }
        int res=0;
        for(int i=0;i<LIS.length;i++)
        {
            if(LIS[i]==max)res+=count[i];
        }
     return res;
    }
}
