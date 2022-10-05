//Approach-binarySearch
//Tc-O(32*n*log(n));
//SC-O(1);

import java.util.*;

public class Main
{
    static int counrSmallerThanEqualtoMid(int []mat,int mid)
    {
        int l=0;int h=mat.length-1;
        //Checking no of elements less than mid using binary search
        while(l<=h)
        {
            int md=l+(h-l)/2;//finding mid in that row;
            if(mat[md]<=mid)//checking if it is lessthan or equal to mid value
            {
                l=md+1;
            }
            else//if not check tha values in array from low to mid;
            {
                h=md-1;
            }
        }
        return l;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int mat[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<n;j++)
		    {
		        mat[i][j]=sc.nextInt();
		    }
		}
		int low=1;//keeping low to 1;
		int high=Integer.MAX_VALUE;//keeping high to Integermax
		int k=mat.length;
		while(low<=high)
		{
		    int mid=low+(high-low)/2;//finding mid;
		    int cnt=0;
		    for(int i=0;i<k;i++)//traversing all rows;
		    {
		        cnt+=counrSmallerThanEqualtoMid(mat[i],mid);//finding no of elements less than in all rows;
		        
		    }
		  
		    if(cnt<=(n*n)/2)low=mid+1;//Checking if count of elements is less than or equal to required value than increment low to mid+1;
		    else high=mid-1;//if not the value lies between low to mid;
		}
			System.out.println(low);
	}

}
