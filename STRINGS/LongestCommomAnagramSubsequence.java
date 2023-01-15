//hashing


package longestcommonanagramsubsequence;
import java.util.*;


public class LongestCommonAnagramSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        //find freq for both sequence
        int frq1[]=new int[26];
        int frq2[]=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            frq1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++)
        {
            frq2[s2.charAt(i)-'a']++;
        }
        int LAS=0;
        //add min of two freq
        for(int i=0;i<26;i++)
        {
            LAS+=Math.min(frq1[i],frq2[i]);
        }
        
        System.out.print(LAS);
    }
    
}
