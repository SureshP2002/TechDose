//leetcode-33
//TC-O(logn)
//Binaray search

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)//if target is equal to mid
            {
                return mid;
            }
            else if(nums[low]<=nums[mid])//if low<=mid
            {
                if(target>=nums[low]&&target<=nums[mid])//chechking if target value is >= than low and <=mid
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
                
            }
            else //if low>mid
            {
                if(target>=nums[mid]&&target<=nums[high])//chehking if target if >=mid and les mid; 
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
