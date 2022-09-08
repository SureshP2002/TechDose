package SortingAlgorithm;
import java.util.*;

public class selectionSort {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();//getting an array of integers
        }
        int minIndex;
        for(int i=0;i<n;i++)
        {
            minIndex=i;//keeeping minimum element as ith element
            for(int j=i+1;j<n;j++ )
            {
                if(arr[minIndex]>arr[j])//checking if it is greater than arr[j];
                {
                    minIndex=j;//updating minIndex;
                }
            }
            //swapping
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
