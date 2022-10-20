//leetcode-496
//TC-O(N);

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<Integer>();//creating an stack
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();//creating HashMap
        int res[]=new int[nums1.length];//creating an array
        int ind=0;
        for(int val:nums2)
        {
            while(!stack.isEmpty()&&stack.peek()<val)//checking if curr val is greater  than previous
            {
                map.put(stack.pop(),val);//puuting  them in combination in map
            }
            stack.push(val);//push the values in stack
        }
        for(int val:nums1)
        {
            if(map.containsKey(val)==true)//if the key is available add to array
            {
                res[ind++]=map.get(val);
            }
            else
            {
                res[ind++]=-1;//orelse add -1;
            }
        }
        return res;
        
    }
}
