import java.util.*;

public class IsPowerOfTwo {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0)
        {
        System.out.println("NO");
        }
        else{
        System.out.println((n&n-1)==0?"YES":"NO");
        }
    }
    
}
