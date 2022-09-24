//leetcode-31
//TC-O(nlogn)

class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]<nums[i])
            {
                index=i;
            }
        }
        if(index==-1)
        {
            Arrays.sort(nums);
            return;
        }
        int swapIndex=index;
        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]>nums[index-1]&&nums[i]<nums[swapIndex])
            {
                swapIndex=i;
            }
        }
        nums[index-1]=nums[index-1]^nums[swapIndex];
        nums[swapIndex]=nums[index-1]^nums[swapIndex];
        nums[index-1]=nums[index-1]^nums[swapIndex];
        Arrays.sort(nums,index,nums.length);
        
    }
}
