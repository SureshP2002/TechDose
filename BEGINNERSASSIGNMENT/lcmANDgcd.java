package BEGINNERSASSIGNMENT;
import java.util.*;

public class lcmANDgcd {
    int gcd(int a,int b)
    {
        return a%b==0?b:gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        lcmANDgcd s=new lcmANDgcd();
        int Gcd=s.gcd(a,b);
        System.out.println(Gcd);
        int LCM=(a*b)/Gcd;
        System.err.println(LCM);
    }
    
}
