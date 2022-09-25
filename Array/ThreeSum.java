//leetcode-15;
//TC-O(N);
//3 sum;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();//creating list for storing elements
        for(int i=0;i<n-2;i++)
        {
            if(i>0&&nums[i]==nums[i-1])continue;//avoid duplicates
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k&&nums[j]==nums[j+1])j++;//avoid dupliactes
                    while(j<k&&nums[k]==nums[k-1])k--;//avoid duplicates
                    j++;
                    k--;
                }
                else if(sum>0)//sum greater means decrement k;
                {
                    k--;
                }
                else//sum lesser means increament j;
                {
                    j++;
                }
            }
         
        }
           return ans;
        
    }
}
