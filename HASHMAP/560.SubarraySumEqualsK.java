//leetcode-560
//TC-O(n)
//approach-hashmap


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();//creating hashMap
        map.put(0,1);//intitialyy puuting key as 0 and value as 1
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];//finding cumulative sum
            if(map.containsKey(sum-k))//if currSum-k contains in tha map then add currSum-k's count
            {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);//adding currSum with count
        }
        return count;
    }
}
