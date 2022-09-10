package SortingAlgorithm;
import java.util.*;

public class mergeSort {
    void Merge(int arr[],int l,int m,int r)
    {
        int n1=m+1-l;//finding size for left array;
        int n2=r-m;//finding size for right array;
        int L[]=new int[n1];//creating array left;
        int R[]=new int[n2];//creating array right;
        for(int i=0;i<n1;i++)
        {
            L[i]=arr[l+i];//first adding elements in left array from array
        }
        for(int i=0;i<n2;i++)
        {
            R[i]=arr[m+1+i];//adding elemnts in right array from array;
        }
        int i=0,j=0;
        int k=l;//initializing the index for merged subArray;
        while(i<n1&&j<n2)
        {
            if(L[i]<=R[j])arr[k++]=L[i++];//adding left if left <= right ;

            else arr[k++]=R[j++];//else adding right;
        }
        //copying the remaining elements of left if any;
        while(i<n1)
        {
            arr[k++]=L[i++];
        }
        //copying the remaining elements of right if any;
        while(j<n2)
        {
            arr[k++]=R[j++];
        }
    }
    void Sort(int arr[],int l,int r)
    {
        if(l<r)//checking if left<right
        {
            int m=l+(r-l)/2;//finding middle m;
            Sort(arr,l,m);//recursive call for sort method for left to middle;
            Sort(arr,m+1,r);//recursive call for sort method for middle+1  to right;
            Merge(arr,l,m,r);//calling the merge method for merging the sorted arrays;
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];//declaring an array;
		for(int i=0;i<n;i++)
		{
		    arr[i]=sc.nextInt();
		}
		mergeSort ob=new mergeSort();//creating object for the class;
		ob.Sort(arr,0,arr.length-1);//calling sort method;
		for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
		
	}
    
}
