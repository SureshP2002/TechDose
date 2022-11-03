//approach-recursion
//TC-O(n)

package sumofnnaturalnumbers;

import java.util.*;
public class SumOfNnaturalnumbers {

     static int SUM(int n)
     {
         if(n==1)return 1;
         return n+SUM(n-1);//recursive call
     }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//getting the input
        System.out.println(SUM(n));
    }
    
}
