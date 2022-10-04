leetcode-668;
//TC-O(m*log(m*n))

class Solution {
    static int lessthanK(int mid,int m,int n)
    {
        int sum=0;
        for(int i=1;i<=m;i++)
        {
            sum+=Math.min(mid/i,n);
        }
        return sum;
    }
    public int findKthNumber(int m, int n, int k) {
        int left=1;
        int right=n*m;
        while(left<=right)
              {
                  int mid=left+(right-left)/2;
                  if(lessthanK(mid,m,n)<k)//finding total no of elemenst before k ;
                  {
                      left=mid+1;
                  }
                  else
                  {
                      right=mid-1;
                  }
              }
        return left;
    }
}
