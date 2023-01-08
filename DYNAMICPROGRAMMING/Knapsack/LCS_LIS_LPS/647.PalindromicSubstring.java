//LPS

class Solution {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean dp[][]=new boolean[len][len];
        int count=0;
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
            count++;
        }
        for(int i=0;i<len-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=true;
                count++;
            }
        }
        for(int i=2;i<len;i++)
        {
            for(int j=0;j<len-i;j++)
            {
                int start=j,end=j+i;
                if(s.charAt(start)==s.charAt(end)&&dp[start+1][end-1])
                {
                    dp[start][end]=true;
                    count++;
                }
            }
        }
        return count;
    }
}
