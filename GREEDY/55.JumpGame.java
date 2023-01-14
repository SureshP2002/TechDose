//lc-55
//approach-greedy

class Solution {
    public boolean canJump(int[] arr) {
        int reachable=0;
        for(int i=0;i<arr.length;i++)
        {
           if(reachable<i)return false;//if the max jump cannot be reached for the index return false;
           reachable=Math.max(reachable,i+arr[i]);//each time finding the max jump from the index

        }
        
        return true;
    }
}
