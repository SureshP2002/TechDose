//TC-O(n^2)


import java.util.*;
public class Main{
    static void mergeTwoSortedArrays(int arr1[],int arr2[],int n,int m)
    {
       for(int i=m-1;i>=0;i--)//traversing from last index in array 2;
       {
           int j,last=arr1[n-1];//keeping last as highest value in array1;
           for( j=n-2;j>=0&&arr1[j]>arr2[i];j--)//traversing from m-2 in array and checking if any element in arr1>arr2[i];
           {
               arr1[j+1]=arr1[j];//swapping them
           }
           if(last>arr2[i])//finally if last element in arr1 is greater than current arr1 element ;
           {
               arr1[j+1]=arr2[i];//replace the j th element with curr arr2 element
               arr2[i]=last;//then put the last element in arr2
           }
       }
    }
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr1[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr1[i]=sc.nextInt();
		}
		int arr2[]=new int[m];
		for(int i=0;i<m;i++)
		{
		    arr2[i]=sc.nextInt();
		}
		mergeTwoSortedArrays(arr1,arr2,n,m);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
