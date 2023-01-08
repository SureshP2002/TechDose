//LPS

class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        boolean dp[][]=new boolean[len][len];
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
        }
        int maxlen=1;
        int startpos=0;
        for(int i=0;i<len-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=true;
                startpos=i;
                maxlen=2;
            }
        }
       for(int i=2;i<len;i++)
       {
           for(int j=0;j<len-i;j++)
           {
               int start=j,end=j+i;
               if(dp[start+1][end-1]&&s.charAt(start)==s.charAt(end))
               {
                   dp[start][end]=true;
                   if(maxlen<i+1)
                   {
                       maxlen=i+1;
                       startpos=start;
                   }

               }
           }
       }
       return s.substring(startpos,startpos+maxlen);
    }
}
