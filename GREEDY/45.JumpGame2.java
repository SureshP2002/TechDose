//lc-45
//approach-greedy

class Solution {
    public int jump(int[] nums) {
        //no of jumps to reach end
        int jumps=0;
        int cur=0;
        int n=nums.length;
        //max step at each pos
        int max_steps=0;
        for(int i=0;i<n-1;i++)
        {
            max_steps=Math.max(max_steps,i+nums[i]);//find max steps
            if(cur==i)//if cur maxstep is i(it means no further step)
            {
                cur=max_steps;//max curr max
                jumps++;
            }
            if(cur>n-1)return jumps;//if already reached 
        }
        return jumps;
    }
}
