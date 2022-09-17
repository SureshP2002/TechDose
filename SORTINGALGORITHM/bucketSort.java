package SORTINGALGORITHM;
import java.util.*;
//import java.util.function.BiConsumer;
public class bucketSort {
    //finding the maximu element;
    int getMax(int arr[],int n)
    {
        int max=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }
    //sorting techinique
    void sort(int arr[],int n)
    {
        int max=getMax(arr,n);//getting the maxixmum element;
        int bucket[]=new int[max+1];//creating buckets for storing elemenst;
        for(int i=0;i<n;i++)
        {
            bucket[arr[i]]++;//adding elements in the bucket;
        }
        int j=0;
        for(int i=0;i<=max;i++)
        {
            while(bucket[i]>0)
            {
                arr[j++]=i;//storing elements in the array
                bucket[i]--;//decrementing the bucket;
            }

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
        bucketSort s=new bucketSort();//creating an object;
        s.sort(arr,n);//bucket sort;
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
