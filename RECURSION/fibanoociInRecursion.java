//leetcode-509
//TC-O(N)

class Solution {
    public int fib(int n) {
      
      if(n<=1)//we know that fib(1)==1 and fib(0)==0
      {
          return n;//returning n
      }
      else
      {
          return fib(n-1)+fib(n-2);//else recursive call for fib(n-2) and fib(n-1);
      }
    }
  
}
