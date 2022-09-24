//leetcode-42;
//TC-O(n)
//Trapping Rain Water;

class Solution {
    public int trap(int[] height) {
        int len=height.length,ans=0;
        int left=1,leftMax=height[0],right=len-2,rightMax=height[len-1];
        while(left<=right)
        {
            if(leftMax<rightMax)
            {
            if(height[left]>=leftMax)
            {
                leftMax=height[left++];
            }
            else
            {
                ans+=leftMax-height[left++];
            }
            }
            else
            {
            if(height[right]>=rightMax)
            {
                rightMax=height[right--];
            }
            else
            {
                ans+=rightMax-height[right--];
            }
            }
            
        }
        return ans;
        
    }
}
