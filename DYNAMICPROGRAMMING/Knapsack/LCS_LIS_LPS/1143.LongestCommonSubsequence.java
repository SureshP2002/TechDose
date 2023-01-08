//LCS


class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int dp[][]=new int[t1.length()+1][t2.length()+1];
        for(int i=1;i<=t1.length();i++)
        {
            for(int j=1;j<=t2.length();j++)
            {
                if(t1.charAt(i-1)==t2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[t1.length()][t2.length()];
    }
}
