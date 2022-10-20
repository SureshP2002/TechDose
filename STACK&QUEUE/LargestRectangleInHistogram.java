//leetcode-84
//Tc-O(N^2)

class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length;//length of an array
        int MaxArea=0;//finding maxArea
        Stack<Integer> stack=new Stack<Integer>();//creating an stack;
        for(int i=0;i<=n;i++)
        {
            int currHeigth=(i==n?0:h[i]);//finding the curr heigth
            while(!stack.isEmpty()&&currHeigth<h[stack.peek()])//checking if curr heigth is less that prev
            {
                int top=stack.pop();//removing prev heigth
                int width=stack.isEmpty()?i:i-stack.peek()-1;//finding width(no of bars)
                int area=width*h[top];//fidning area;
                MaxArea=Math.max(MaxArea,area);//finding max;
            }
            stack.push(i);//adding the index;
        }
        return MaxArea;
        
    }
}
