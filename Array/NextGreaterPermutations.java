//leetcode-31
//TC-O(nlogn)

class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        //chechking for peak;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]<nums[i])
            {
                index=i;
            }
        }
        //if no peak then it is sorted;
        if(index==-1)
        {
            Arrays.sort(nums);
            return;
        }
        int swapIndex=index;
        //finding the element which is greater then second peak and less then peak;
        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]>nums[index-1]&&nums[i]<nums[swapIndex])
            {
                swapIndex=i;
            }
        }
        //swaping element with second peak;
        nums[index-1]=nums[index-1]^nums[swapIndex];
        nums[swapIndex]=nums[index-1]^nums[swapIndex];
        nums[index-1]=nums[index-1]^nums[swapIndex];
        //after sorting the elements from peak;
        Arrays.sort(nums,index,nums.length);
        
    }
}
