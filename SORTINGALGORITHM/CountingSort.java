package SORTINGALGORITHM;
import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n+1];//declaring array
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]>max)
            {
                max=arr[i];//finding maximum element
            }
        }
        max=max+1;//increment max+1 for using in array;
        int has[]=new int[max];
        int ansArray[]=new int[n];
        //find the frequency of array elements
        for(int i=0;i<n;i++)
        {
            has[arr[i]]++;
        }
        //find the cummulative sum of all the elements in the has
        for(int i=1;i<max;i++)
        {
            has[i]=has[i-1]+has[i];
        }
        for(int i=0;i<n;i++)
        {
          int pos=--has[arr[i]];//finding the position and decrementing the count;
          ansArray[pos]=arr[i];//putting the array elements in the positon;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(ansArray[i]+" ");
        }

    }
    
}
