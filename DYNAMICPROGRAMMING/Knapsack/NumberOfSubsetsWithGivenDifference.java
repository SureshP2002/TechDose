//(0/1) Knapsack

package numberofsubsetswithgivendifference;
import java.util.*;


public class NumberOfSubsetsWithGivenDifference {

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=5;
        int arr[]=new int[]{1,2,3,1,2};
        int diff=1;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        if(sum-diff<0||(sum-diff)%2!=0)
        {
            System.out.print("0");
            System.exit(0);
        }
        int target=(sum+diff)/2;
        int dp[][]=new int[n+1][target+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=target;++j)
            {
                if(j==0)dp[i][j]=1;
                else if(i==0&&j>0)dp[i][j]=0;
                else if(arr[i-1]>j)dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
            }
        }
        System.out.println(dp[n][target]);
        
    }
    
}
