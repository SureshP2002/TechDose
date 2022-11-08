//leetcode-39
//approach-recursion(backtracking)

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void Combination(int[] arr,int target,int index,List<Integer> l)
    {
        if(target==0)//if target is zero then there is a combination
        {
            ans.add(new ArrayList(l));//adding into the 
            return;
        }
        if(index==arr.length)return;//if index reaches the arraylength then return 
        if(target>=arr[index])//if target is greater than curr arr[index]
        {
        
        l.add(arr[index]);//adding to list
        Combination(arr,target-arr[index],index,l);//recursive call pick the curr elemnt
        l.remove(l.size()-1);
       
        }
         Combination(arr,target,index+1,l);//not pick
        
        
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l=new ArrayList<>();//creating an list
        Combination(candidates,target,0,l);//function call
        return ans;
        
    }
}
