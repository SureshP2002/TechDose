//leetcode-56
//TC-O(N);

class Solution {
    public int[][] merge(int[][] arr) {
        List<int[]> ans=new ArrayList<>();//creating array inside a list;
        if(arr.length<=1)return arr;//return same array if len <=1
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));//sorting the array using the lambda functions
        int start=arr[0][0];//keeping initially start position as [0][0]
        int end=arr[0][1];//end position as [0][1];
        for(int[] i:arr)
        {
            if(i[0]<=end)//checcking if current start position is less or eqauls to previous end position
            {
                end=Math.max(end,i[1]);//finding max of curr end and prev end
            }
            else
            {
                ans.add(new int[]{start,end});//adding  to list as intervals 
                start=i[0];//upadte start and end with new interval
                end=i[1];
            }
        }
        ans.add(new int[]{start,end});//finally there is one start and end so that need to bo added
        
         return ans.toArray(new int[0][]);//returning the whole list as array;
    }
}
