//leetcode -509
//TC-(n)

class Solution {
    public int fib(int n) {
      int arr[]=new int[n+2];//creating an array of length +2
      arr[0]=0;//keeping fib(0)=0;
      arr[1]=1;//keeping fib(1)=1;
        for(int i=2;i<n+2;i++)//traversing from second index
        {
            arr[i]=arr[i-1]+arr[i-2];//fib(i)=fib(i-1)+fib(i-2);
        }
        return arr[n];
    }
  
}
