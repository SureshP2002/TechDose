package day4NumberTheory;
import java.util.*;

public class Gcd {
    int gcd(int a,int b)
    {
        return a%b==0?b:gcd(b,a%b);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        Gcd s=new Gcd();
        int ans=s.gcd(a,b);
        System.out.println(ans);
        //toFindLCM
        int lcm=(a*b)/ans;
        System.out.println(lcm);

    }
    
}
