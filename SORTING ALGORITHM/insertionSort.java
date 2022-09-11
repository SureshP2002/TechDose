package SortingAlgorithm;
import java.util.*;

public class insertionSort {
    public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int i,j;
    int arr[]=new int[n];//declaring an array 
    for( i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
    }
    List<Integer> ans=new ArrayList<Integer>();//Declaring an arraylist for dynamic array implementation;
    for(i=0;i<n;i++)
    {
           ans.add(arr[i]);//inserting the elements int the list;
           for( j=ans.size()-1;j>0;j--)//using size method;
           {
            if(ans.get(j)>=ans.get(j-1))//accessing the element in the list;
            break;
            Collections.swap(ans,j-1,j);//swapping the element using collections method;
           }
    }
    for(int c:ans)
    {
        System.out.print(c+" ");
    }
}
    
}
