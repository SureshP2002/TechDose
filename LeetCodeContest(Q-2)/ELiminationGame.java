//leetcode-390
//TC-O(N)


class Solution {
    public int lastRemaining(int n) {
        boolean left=true;//initialy keeping left is true
        int remaining =n;//currently remaining is n
        int step=1;
        int head=1;
        while(remaining >1)//until remaining is 1
        {
            if(left||remaining%2==1)//if remaining is odd or left if true
            {
                head=head+step;
                
            }
            step=step*2;
            left=!left;
                remaining=remaining/2;
            
        }
        return head;
        
    }
}
