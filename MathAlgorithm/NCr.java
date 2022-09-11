package MathAlgorithm;
import java.util.*;

public class NCr {
    int[][] arr(int n,int r)
    {
        int mat[][]=new int[n+1][n+1];//creating matrix with size n+1;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                {
                    mat[i][j]=1;
                }
                else
                {
                    mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
                }
            }
            
        }
        return mat;
}
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        NCr a=new NCr();//creating object of class
        int ans[][]=a.arr(n,r);//sending parameter n and r
        System.out.println(ans[n][r]);//printf nCr;

    }
    
}
