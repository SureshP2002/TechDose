//leetcode-378
//TC-O(nlog(n^2));

class Solution {
    static int Noelements(int mid,int [][]matrix)
        
    {
        int count=0;
        int row=0;
        int col=matrix.length-1;
      for(row=0;row<matrix.length;row++)//upto last row element
      {
          while(col>=0&&matrix[row][col]>mid)//fiding how many elements less than mid row by row;
          {
              col--;
          }
          count+=(col+1);
      }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        int low=matrix[0][0],high=matrix[m-1][n-1];
        while(low<high)
        {
            int mid=low+(high-low)/2;//finding mid value
            int count=Noelements(mid,matrix);//finding no of elemenst less than kth value;
            if(count<k)//if no of elements lesser than kth value than increment low to mid+1;
            {
             low=mid+1;
            }
            else //if no fo elements greater than kth value than increment high to mid;
            {
                high=mid;
            }
        }
        return high;
        
    }
}
