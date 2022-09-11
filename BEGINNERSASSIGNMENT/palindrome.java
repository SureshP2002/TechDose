package BEGINNERSASSIGNMENT;
import java.util.*;
import java.lang.*;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
            {
                System.out.print("NOT A PALINDROME");
                System.exit(0);
            }
        }
        System.out.print("IT IS PALINDROME");
    }
    
}
