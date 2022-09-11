package MathAlgorithm;
import java.util.*;

public class GcdandLcm {
    int gcd(int a,int b)
    {
        return a%b==0?b:gcd(b,a%b);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        GcdandLcm s=new GcdandLcm();
        int ans=s.gcd(a,b);
        System.out.println(ans);
        //toFindLCM
        int lcm=(a*b)/ans;
        System.out.println(lcm);

    }
    
}
