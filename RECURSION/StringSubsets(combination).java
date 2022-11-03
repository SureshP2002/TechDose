//approach-recursion+backtracking
//TC-O(2^n)

package stringsubsets;
import java.util.*;

public class StringSubsets {
    static List<String> l=new ArrayList<>();//creating an list for storing the subsets
    static String curr="";//empty string
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();//getting the input
        subsets(str,0,str.length(),curr);//calling function for subsets
        System.out.println(l);
    }
    static void subsets(String str,int start,int end,String curr)
    {
        if(start==end)//if start==end add it to the list
        {
            l.add(curr);
            return;//return the curr function
        }
        subsets(str,start+1,end,curr);//recursive call with start+1
        curr=curr+str.charAt(start);//adding character
        subsets(str,start+1,end,curr);//backtracking
        
    }
    
}
