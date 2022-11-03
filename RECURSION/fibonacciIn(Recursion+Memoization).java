//approach-recursion+memoization
//TC-O(N)


package fibonaccirecursion;
import java.util.*;


public class FIbonacciRecursion {
    static int arr[]=new int[31];//creating an array  
    static int fib(int n)
    {
        if(n==0)//if n is 0 return 0;
        {
            return n;
        }
        else if(arr[n]!=0)//if arr[n] has the value then it already stored some value
        {
            return arr[n];//returning the already stored value
        }
        else//if arr[n] has value 0 the we need to find the value by calling fib(n-1)+fib(n-2)
        {
            arr[n]=fib(n-1)+fib(n-2);//once the value is stored then we return them
            return arr[n];
        }
    }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr[0]=0;//initial values
        arr[1]=1;
        System.out.print(fib(n));
        
        
    }
    
}
