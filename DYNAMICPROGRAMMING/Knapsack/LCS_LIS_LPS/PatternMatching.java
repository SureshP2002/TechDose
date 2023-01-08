//LCS


package patternmatching;
import java.util.*;
public class PatternMatching {

   
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String pattern=sc.next();
       String str=sc.next();
       int len1=pattern.length();
       int len2=str.length();
       String dp[][]=new String[len1+1][len2+1];
       for(int i=0;i<=len1;i++)
       {
           for(int j=0;j<=len2;j++)
           {
               if(i==0||j==0)dp[i][j]="";
               else if(pattern.charAt(i-1)==str.charAt(j-1))dp[i][j]=dp[i-1][j-1]+pattern.charAt(i-1);
               else dp[i][j]=dp[i][j-1].length()>dp[i-1][j].length()?dp[i][j-1]:dp[i-1][j];
           }
       }
       System.out.print(dp[len1][len2].equals(pattern)?"TRUE":"FALSE");
    }
    
}
