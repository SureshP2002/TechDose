import java.util.*;

public class Subsets {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];//getting an array of intger
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        List<List<Integer>> ans=new ArrayList<>();//creating a list which stores the lists of a;
        for(int i=0;i<Math.pow(2,n);i++)//traversing for 2^n times;
        {
            List<Integer> a=new ArrayList<>();//creating a list which stores the elements of arr;
            
            for(int j=0;j<n;j++)//traversing through the array;
            {
                
                if((i&(1<<j))>0)//bitwise AND with 1rightshifted by j position to find if the bit is set or not;
                {
                    a.add(arr[j]);//using inbuild method (add) to add elements in the list;
                }
            }
            ans.add(a);//using inbuild method (add) to add the list (a) in the list (ans); 
            
        }
        System.out.println(ans);
    }
    
}
