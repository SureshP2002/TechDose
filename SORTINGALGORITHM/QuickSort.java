package SORTINGALGORITHM;
import java.util.*;

public class QuickSort {
    int partition(int a[],int start,int end)
    {
        int pivot=a[end];//keeping pivot as last element;
        int i=(start-1);//initializing some position for the i to place the element;
        for(int j=start;j<end;j++)
        {
            if(a[j]<pivot)//if the cuurent element is smaller than the pivot;
            {
                i++;//increment index of smaller element;
                int t=a[i];
                a[i]=a[j];//swapping them;
                a[j]=t;
            }
        }
        //placing the pivot element at its correct position
        int t=a[i+1];
        a[i+1]=a[end];
        a[end]=t;
        return (i+1);

    }
    void quick(int a[],int start,int end)
    {
        if(start<end)//checking whether start is less than end;
        {
            int p=partition(a,start,end);//partitioning the array into subarrays with pivot;
            quick(a,start,p-1);//recursive call for left subarray;
            quick(a, p+1, end);//recursive call for right subArray;
        }
    }
    void print(int a[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");//printing the elements in the array;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];//declaring an array
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sc.close();
        QuickSort s=new QuickSort();//creating object for the class;
        s.quick(arr,0,n-1);//calling quick function;
        s.print(arr,n);//calling print function;
    }
    
}
