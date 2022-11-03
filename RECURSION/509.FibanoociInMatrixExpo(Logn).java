//leetcode -509
//TC-log(n)

class Solution {
    int base[][]=new int[][]{{1,1},{1,0}};
    static int[][] MulBaseMatrix(int a[][],int b[][])
    {
        int res[][]=new int[2][2];//storing the result
        for(int i=0;i<2;i++)/
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<2;k++)
                {
                    res[i][j]+=(a[k][j]*b[i][k]);//adding them based on 7 method
                }
            }
        }
        return res;
    }
    static int[][] findFib(int base[][],int power)
    {
        if(power==1)return base;//if the power is 1 then we need to multipy matrix once so return(base condition)
        int half=power/2;//dividing power by 2 because if we need to find base^8===(base^4)*(base^4)
        int mat[][]=findFib(base,half);//recursive call for reducing power
        mat=MulBaseMatrix(mat,mat);//once it reaches the 1 it will come for multiplying base matrixes
        if(power%2!=0)//if power is odd then mul again with base matrix
        {
            mat=MulBaseMatrix(mat,base);//base^7==(base^3)*(base^3)*(base^1);
        }
        return mat;
    }
    
    public int fib(int n) {
       if(n<=1)return n;//if n is less than or equal to 1 then fib(0)=0 and fib(1)=1;
        int ans[][]=findFib(base,n-1);//ans matrix for finding fib(n)//fib[][]=(base)^n-1;
        return ans[0][0];//then the answer will be at fib[0][0];
    
    }
  
}
