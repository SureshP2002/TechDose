//LCS

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        //this problem is like lcs
        int len1=nums1.length;
        int len2=nums2.length;
        int dp[][]=new int[len1+1][len2+1];//creating dp array
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                if(i==0||j==0)
                      dp[i][j]=0;//if 0 means put 0 because no elements
                else if(nums1[i-1]==nums2[j-1])//if both element equals
                      dp[i][j]=1+dp[i-1][j-1];//increase 1+prev common elements
                else 
                      dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);//else(check if including nums1[i]||num2[j] giving greater subsequence) then add it max
            }
        }
        return dp[len1][len2];//ans
    }
}
