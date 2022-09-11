package MathAlgorithm;
import java.util.*;

public class catalanNumbers {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        //dynamic programming approach;
        //TC: O(N^2);

        long arr[]=new long[n+2];   //creating an array for storing catalan values

        arr[0]=1;        //initializing first index element ot 1;
        arr[1]=1;      //initializing second index element to 1;
        //as we know catalan series is  - 1,1,2,5,14,42,132.......
        for(int i=2;i<n+1;i++)//traversing from index 2;
        {
            for(int j=0;j<i;j++)
            {
                arr[i]+=arr[j]*arr[i-j-1];//catalan[n]=catalan[0]*catalan[n-1]+catalan[1]*catalan[n-2]+....+catalan[i]*catalan[n-i-1]+.....+catalan[n-1]*catalan[0];
            }
        }
        System.out.println(arr[n]);
    }
    
}
