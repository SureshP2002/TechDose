//LPS(LCS)

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        int len1=s1.length();
        int len2=s2.length();
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                if(i==0||j==0)dp[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
}
