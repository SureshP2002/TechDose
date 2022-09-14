package BEGINNERSASSIGNMENT;
import java.util.*;

public class transposeOfMatrix {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<m;i++)//tranpose->2*3->>3*2 so we are keeping column first;
        {
            for(int j=0;j<n;j++)//row second
            {
                System.out.print(mat[j][i]+" ");
            }
            System.err.println();
        }

    }
    
}
