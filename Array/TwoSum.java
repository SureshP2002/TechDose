//leetcode-1;
//TC-O(n);
//HashMap Approach;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int require=target-nums[i];
            if(map.containsKey(require))
            {
                return new int[]{map.get(require),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
