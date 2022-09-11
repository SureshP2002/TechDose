package BEGINNERSASSIGNMENT;
import java.util.*;

public class pascalsTriangle {
    int[][] pascal(int n)
    {
        int ans[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)ans[i][j]=1;
                else ans[i][j]=ans[i-1][j-1]+ans[i-1][j];//adding lastrow lastcol +lastrow samecol
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pascalsTriangle s=new pascalsTriangle();//creating an object for the class;
        int [][]mat=s.pascal(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]!=06)
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
