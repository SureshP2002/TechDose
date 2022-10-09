//leetcode- 1
//Tc-O(N)
//approach-HashMap


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();//creating hashMap for storing value and key
        for(int i=0;i<nums.length;i++)
        {
            int require=target-nums[i];//subtracting the elements for target to get required number
            if(map.containsKey(require))//checking whether the required number is found or not
            {
                return new int[]{map.get(require),i};//returning the index
            }
            map.put(nums[i],i);//adding the element itself
          
        }
        return null;
    }
}
