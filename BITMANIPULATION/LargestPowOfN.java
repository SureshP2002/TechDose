import java.util.*;

public class LargestPowOfN {
    public static void  main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ctr=0;
        while(n>0)
        {
            n=n>>1;
            ctr++;
        }
        System.out.println(1<<ctr-1);
    }
    
}
