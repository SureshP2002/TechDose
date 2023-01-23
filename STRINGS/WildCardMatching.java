//approach-dp

class Solution {
    public boolean isMatch(String s, String p) {
        int n=p.length();
        int m=s.length();
        boolean dp[][]=new boolean[n+1][m+1];
        //case:1 if both strings are empty means
        dp[0][0]=true;
        //case:2 if text empty and pattern has charcter means then we cannot match them
        for(int j=1;j<=m;j++)
        {
            dp[0][j]=false;
        }
        //case:3 if text not empty and pattern is empty(we need check if the remaining text contains only the '*')
        for(int i=1;i<=n;i++)
        {
            boolean flag=true;
            for(int ii=1;ii<=i;ii++)
            {
                if(p.charAt(ii-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[i][0]=flag;
        }
        //case 4: matching condition
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='?')//if both char are equal or if '?' comes
                        dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(i-1)=='*')//if star comes means move text or move pattern
                        dp[i][j]=dp[i-1][j]|dp[i][j-1];
                else //if not matches
                        dp[i][j]=false;

            }
        }
        return dp[n][m];
    }
}
