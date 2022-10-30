//leetcode-5252
//TC-O(N)
//approach-hashmap

class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nums[i]=-1;//changing all the zeros to 1
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();//creating the hashmap
        int sum=0,max=0;
        map.put(0,-1);//initialy adding key 0 an value -1
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];//finding sum
            if(map.containsKey(sum))//if the sum already exists 
            {
                max=Math.max(max,i-map.get(sum));//finding the length currIndex-prevSumIndex
            }
            else
            {
                map.put(sum,i);//adding the sum key and index value
            }
        }
        return max;
        
    }
}
