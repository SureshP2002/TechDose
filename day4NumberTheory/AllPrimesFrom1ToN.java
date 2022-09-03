package day4NumberTheory;
import java.util.*;

public class AllPrimesFrom1ToN {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //seive of eratosthenes;
        if(n<2)
        {
            System.out.print("NO PRIME NUMBERS");
        }
        else{
            boolean prime[]=new boolean[n+1];//creating boolean array a
            Arrays.fill(prime,true);//making all the prime array ture
            for(int i=2;i*i<n;i++)//traversing from 2 to root n;
            {
                if(prime[i])
                {
                    for(int j=i*i;j<=n;j+=i)
                    {
                        prime[j]=false;//making mulitple of i alos false;
                    }
                }
            }

            for(int i=1;i<=n;i++)
            {
                if(prime[i])//printing only the elements that are true;
                {
                    System.out.print(i+" ");
                }
            }
        }
    }
    
}
