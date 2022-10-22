//leetcode-2139
//TC-O(N)
/*You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.

In one move, you can either:

Increment the current integer by one (i.e., x = x + 1).
Double the current integer (i.e., x = 2 * x).
You can use the increment operation any number of times, however, you can only use the double operation at most maxDoubles times.

Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target starting with 1.

 

Example 1:

Input: target = 5, maxDoubles = 0
Output: 4
Explanation: Keep incrementing by 1 until you reach target.
Example 2:

Input: target = 19, maxDoubles = 2
Output: 7
Explanation: Initially, x = 1
Increment 3 times so x = 4
Double once so x = 8
Increment once so x = 9
Double again so x = 18
Increment once so x = 19*/

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int res=0;
        while(target>1&&--maxDoubles>=0)//reducing the  target
        {
            res+=1+target%2;//if there is a remiander then add it
            target/=2;
        }
        return res+target-1;
      
        
    }
}
