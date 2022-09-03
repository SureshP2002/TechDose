import java.util.*;

public class CountSetBit {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ctr=0;
        while(n>0)
        {
              if((n&1)==1)
              {
                ctr++;
              }
              n=n>>1;
        }
        System.out.println(ctr);

    }
    
}
