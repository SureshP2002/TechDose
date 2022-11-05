//leetcode-46
//approach-recursion


class Solution {
         
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> l=new ArrayList<>();//creating an 2d list
        permutations(nums,0,nums.length-1,l);//function call
        return l;
    }
    public void permutations(int arr[],int start,int end,List<List<Integer>> l)
    {
        if(start==end)//if start is equal to end then start adding the element 
        {
            List<Integer> a=new ArrayList<>();//creating an new list
            for(int i=0;i<=end;i++){
                a.add(arr[i]);
            }
            l.add(a);//adding to the 2d list
        }
        
            for(int i=start;i<=end;i++)
            {
                swap(arr,start,i);//swaping arr[start] with arr[i]
                permutations(arr,start+1,end,l);//recursion call to fix next index position(left+1)
                swap(arr,start,i);//backtracking to original array
            }
        
    }
    public void swap(int []arr,int i,int j)
    {
        int t=arr[i];//swaping them
        arr[i]=arr[j];
        arr[j]=t;
    }
}
