//leetcode-52
//approach-recursion(backtracking)

class Solution {
    int count=0;
     public void solve(int col,int n,char mat[][],int leftrow[],int upperLeftdiagonal[],int lowerLeftdiagonal[])
    {
        if(col==n)//if the col reaches ths size n then we can place the queen without any attacks
        {
          count++;//Increament count
        }
        for(int row=0;row<n;row++)
        {
            //checking if there is leftrow upperleft and lowerleft diagonal is zero(it means no queen can be attecked)
            if(leftrow[row]==0 && upperLeftdiagonal[(n-1)+(col-row)]==0 && lowerLeftdiagonal[row+col]==0)
            {
                mat[row][col]='Q';//placing 'Q'
                leftrow[row]=1;//making curr row as 1;
                upperLeftdiagonal[(n-1)+(col-row)]=1;//making curr upperleftdiagonal as 1;
                lowerLeftdiagonal[row+col]=1;//making curr uppperleftdiagonal as 1;
                solve(col+1,n,mat,leftrow,upperLeftdiagonal,lowerLeftdiagonal);//recursive call
                 mat[row][col]='.';//once the function gets checked and backtrack starts
                leftrow[row]=0;//making all as 0 for next cobination check
                upperLeftdiagonal[(n-1)+(col-row)]=0;
                lowerLeftdiagonal[row+col]=0;
                
                
            }
        }
    }
    public int totalNQueens(int n) {
            char mat[][]=new char[n][n];//creating an matrix for checking and placing queen
        for(char arr[]:mat)
        {
            Arrays.fill(arr,'.');//initially filling it with dot
        }
        int leftrow[]=new int[n];//leftrow array for checking if any ellement is present in the same leftrow
        int upperLeftdiagonal[]=new int[2*n-1];//upperdiagonal array for checking if an element is present in the same upperdiagonal
        int lowerLeftdiagonal[]=new int[2*n-1];//lowerdiagonal array for checking if an element is present in the same lowerdiagonal
        solve(0,n,mat,leftrow,upperLeftdiagonal,lowerLeftdiagonal);//function call
        return count;
        
    }
}
