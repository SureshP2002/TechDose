//straightForward

package differenceoftwostrings;
import java.util.*;


public class DifferenceOfTwoStrings {

    public static  boolean isSmaller(String s1,String s2)
    {
        int n1=s1.length();
        int n2=s2.length();
        if(n1<n2)return true;
        if(n1>n2)return false;
        for(int i=0;i<n1;i++)
        {
            if(s1.charAt(i)<s2.charAt(i))return true;
            else if(s1.charAt(i)>s2.charAt(i))return false;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        if(isSmaller(s1,s2))
        {
            String t=s1;
            s1=s2;
            s2=t;
        }
        String ans="";
        s1=new StringBuilder(s1).reverse().toString();
        s2=new StringBuilder(s2).reverse().toString();
        int carry=0;
        int sub=0;
        int n1=s1.length(),n2=s2.length();
        for(int i=0;i<n2;i++)
        {
            sub=(s1.charAt(i)-'0')-(s2.charAt(i)-'0')-carry;
            if(sub<0)
            {
                sub=sub+10;
                carry=1;
            }
            else carry=0;
            ans+=sub+"";
        }
        for(int i=n2;i<n1;i++)
        {
            sub=(s1.charAt(i)-'0')-carry;
            if(sub<0)
            {
                sub=sub+10;
                carry=1;
            }
            else carry=0;
            ans+=sub+"";
        }
        System.out.print(new StringBuilder(ans).reverse().toString());
                
    }
    
}
