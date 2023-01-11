

package oneeditdistance;
import java.util.*;

public class OneEditDistance {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word1=sc.next();
        String word2=sc.next();
        int len1=word1.length();
        int len2=word2.length();
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                if(i==0)
                   dp[i][j]=j;
                else if(j==0)
                   dp[i][j]=i;
                else if(word1.charAt(i-1)==word2.charAt(j-1))//skip
                   dp[i][j]=dp[i-1][j-1];
                else                   //insert            //delete   //replace
                   dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        System.out.println(dp[len1][len2]==1?"YES":"NO");
    }
    
}
