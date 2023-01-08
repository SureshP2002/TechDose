//LCS

package longestrepeatingsubsequence;
import java.util.*;
public class LongestRepeatingSubsequence {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int dp[][]=new int[s.length()+1][s.length()+1];
        
        //same as LCS
        for(int i=0;i<s.length()+1;i++)
        {
            for(int j=0;j<s.length()+1;j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(s.charAt(i-1)==s.charAt(j-1)&&i!=j)
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
            
        }
        System.out.println(dp[s.length()][s.length()]);
        
    }
    
}
