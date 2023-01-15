//approach-dp

package longestrecurringsubsequence;
import java.util.*;

public class LongestRecurringSubsequence {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=str.length();
        //creating dp array for n+1
        int dp[][]=new int[n+1][n+1];
        //same as lps but if chars equal and index are not euqal
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                      dp[i][j]=0;
                else if(str.charAt(i-1)==str.charAt(j-1)&&i!=j)
                      dp[i][j]=1+dp[i-1][j-1];
                else 
                      dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[n][n]);
        
    }
    
}
