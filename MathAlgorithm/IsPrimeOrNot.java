package MathAlgorithm;
import java.util.*;
import java.lang.*;

public class IsPrimeOrNot {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    for(int i=2;(i*i)<n;i++)// chechking only upto root of n;
    {
        if(n%i==0)//if there is any factor;
        {
            System.out.print("NOT A PRIME NUMBER");
            System.exit(0);
        }
    }
    System.out.print("PRIME NUMBER");
    }

    
}
