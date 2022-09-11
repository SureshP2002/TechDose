package MathAlgorithm;
import java.util.*;

public class PrimeFactors {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    for(int i=2;i*i<=n;i++)//iterating upto root n;
    {
        while((n%i)==0)//checking if n is divisible i
        {
            n/=i;//divide n by i ;
            System.out.print(i+" ");
        }
       
    }
    if(n>1)//finally if the value of n is not zero,then print remaining value;
    {
        System.out.print(n+" ");
    }

    

    }
    
}
