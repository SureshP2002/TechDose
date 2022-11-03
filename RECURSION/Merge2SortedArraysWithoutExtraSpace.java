//approach-recursion/divide and conquer
//Tc-O(n*m)

package mergesortwithoutextraspace;
import java.util.*;


public class MergeSortWithOutExtraSpace {
   static void sort(int arr[],int low,int high,int mid)//conquer
   {
       for(int i=high;i>mid;i--)//traverse from second array  last elemnt
       {
           int j,last=arr[mid];//keeping mid element as last
           for(j=mid-1;j>=low&&arr[j]>arr[i];j--)//traversing upto curr arr[j]<arr[i]
           {
               arr[j+1]=arr[j];// if the curr arr[j] is greater than arr[i] then put arr[j+1] to current arr[j]
           }
           if(last>arr[i])//if last(in array 1) is greater than second array arr[i] then put first arr+1=second array(i)
           {
               arr[j+1]=arr[i];
               arr[i]=last;
           }
       }
   }
    static void MergeSort(int arr[],int low,int high)
    {
        if(low<high)//only upto low<high else it swap again back too original array
        {
            int mid=low+(high-low)/2;//finding the middle element
            MergeSort(arr,low,mid);//divide from low mid
            MergeSort(arr,mid+1,high);//divide from mid+1 to high
            sort(arr,low,high,mid);//again sort two arrays
            
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        MergeSort(arr,0,n-1);//calling function
        System.out.print(Arrays.toString(arr));
        
    }
    
}
