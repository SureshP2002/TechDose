package SORTINGALGORITHM;
import java.util.*;

public class radixSort {
    int max(int arr[],int n)
    {
        int large=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]>large)
            {
                large=arr[i];
            }
        }
        return large;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();//getting input;
        }
        radixSort s=new radixSort();//creating object
        int large=s.max(arr,n);//finding the maximu element
        int digits=(int)(Math.log(large)/Math.log(10));//finding the no of digits in largest number;
        for(int i=0;i<=digits;i++)//0 to no of digits;
        {
            int []hash=new int[10];//creating hash for decimal;
            for(int j=0;j<n;j++)
            {
                int index=(arr[j]/(int)(Math.pow(10,i)))%10;//finding index starting from rightmost digit;
                hash[index]++;
            }
            for(int k=1;k<10;k++)
            {
                hash[k]+=hash[k-1];//finding cummulative sum;
            }
            int ans[]=new int[arr.length];//new arr for storing ans;
            for(int l=arr.length-1;l>=0;l--)
            {
                int ind=(arr[l]/((int)Math.pow(10,i)))%10;//finding index to place in the array starting  from rightmost;
                ans[--hash[ind]]=arr[l];
            }
            arr=ans;//copying ans array to arr array;

        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
