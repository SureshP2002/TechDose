//TC-O(n^2)


import java.util.*;

class Solution
{
    //Function to merge the arrays.
    public static void swap(long arr1[],long arr2[],int l,int r)
    {
        if(arr1[l]>arr2[r])
        {
            arr1[l]=arr1[l]^arr2[r];
             arr2[r]=arr1[l]^arr2[r];
              arr1[l]=arr1[l]^arr2[r];
        }
    }
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
      int len=(n+m);
      int gap=(len/2)+(len%2);
      while(gap>0)
      {
          int left=0;
          int right=gap;
          while(right<len)
          {
              if(left<n&&right<n)
              {
                  swap(arr1,arr1,left,right);
              }
              else if(left>=n)
              {
                  swap(arr2,arr2,left-n,right-n);
              }
              else
              {
                  swap(arr1,arr2,left,right-n);
              }
              left++;
              right++;
            
          }
            if(gap==1)break;
              gap=(gap/2)+(gap%2);
      }
    }
}
