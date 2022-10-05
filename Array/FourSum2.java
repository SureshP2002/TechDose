//leetcode-454;
//TC-O(n1*n2)+O(n3*n4);

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i:nums1)
        {
            for(int j:nums2)
            {
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        for(int k:nums3)
        {
            for(int l:nums4)
            {
                count+=map.getOrDefault(-(k+l),0);
            }
        }
                
        return count;
    }
}
