//leetcode-42
//Approach-Two pointer 
//Tc-O(n)


class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int ans=0;
        int left=1;//keeping left initially index 1 because no water can be trapped in 0 
        int leftMax=height[0];//initializing leftMax to first element
        int right=len-2;//keeping left initially index len-2 because no water ca be trapped in len-1 
        int rightMax=height[len-1];//rightMAx initially last element
        while(left<=right)
        {
            if(leftMax<rightMax)//checking if leftMax is lesser than rightMax
            {
                if(height[left]<=leftMax)//checking if height of curr element is less than LeftMax element
                {
                    ans+=leftMax-height[left];//adding to ans
                    left++;
                    
                }
                else//if not leftMax is updated
                {
                    leftMax=height[left];
                    left++;
                }
            }
            else//if rightMAx is greater
            {
                if(height[right]<=rightMax)//checking if height of curr element is less than the prev RightMax
                {
                    ans+=rightMax-height[right];//adding to ans
                    right--;
                }
                else//if not rightMax is updated
                {
                    rightMax=height[right];
                    right--;
                }
            }
           
            
        }
        return ans;
        
    }
}
