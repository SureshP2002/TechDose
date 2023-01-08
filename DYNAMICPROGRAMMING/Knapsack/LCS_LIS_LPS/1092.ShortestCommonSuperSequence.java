//LCS

class Solution {
    public static String findlcs(String s1,String s2)
    {
        int len1=s1.length();
        int len2=s2.length();
        String dp[][]=new String[len1+1][len2+1];//dp array
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                if(i==0||j==0)dp[i][j]="";// 0 means empty string
                else if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);//if both char equal then add with prev subsequence
                else dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];//else take the subseq which is large
            }
        }
        return dp[len1][len2];
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        String lcs=findlcs(s1,s2);//first finding the longest common subsequence
        String s3="";
        int p1=0,p2=0;//taking two pointer one for s1 and one for s2
        for(char ch:lcs.toCharArray())
        {
            while(s1.charAt(p1)!=ch)
            {
                s3+=s1.charAt(p1++);//adding to s3 till char ch in s1 arises
            }
             while(s2.charAt(p2)!=ch)
            {
                s3+=s2.charAt(p2++);//adding to s3 till char ch in s2 arises
            }
            s3+=ch;//finally adding one time the char ch to reduce SCS
            p1++;//increament both
            p2++;
        }
        s3+=s1.substring(p1)+s2.substring(p2);//finally add if s1 and s2 has balance elemnts 
        return s3;
    }
}
