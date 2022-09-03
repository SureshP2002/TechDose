import java.util.*;

public class RightMostOnePosition {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        if(n==0)
        {
            System.out.println("INVALID INPUT");
        }
        while(n>0)
        {
            if((n&1)>0)
            {
                System.out.println(1<<ans);
                System.exit(0);
            }
            n=n>>1;
            ans++;
        }
    }
    
}
