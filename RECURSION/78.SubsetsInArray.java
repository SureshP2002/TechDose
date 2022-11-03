//leetcode-78
//TC-(2^n)

class Solution {
     List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        combination(nums,0,nums.length,new ArrayList<>());//calling the function for finding the subsets
        return ans;
    }
    public void combination(int nums[],int start,int end,List<Integer> l)
    {
        if(start==end)//if start==end add new list to ans list
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        combination(nums,start+1,end,l);//exclude
        l.add(nums[start]);//adding element
        combination(nums,start+1,end,l);//include
        l.remove(l.size()-1);//remove
    }
}
