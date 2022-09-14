package BEGINNERSASSIGNMENT;
import java.util.*;
import java.lang.*;

public class frequencyOfstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int has[]=new int[128];
        for(int i=0;i<s.length();i++)
        {
            has[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(has[s.charAt(i)]>0)
            {
                System.out.println(s.charAt(i) + "->"+ has[s.charAt(i)]);
                has[s.charAt(i)]=0;
            }
        }
    }
    
}
