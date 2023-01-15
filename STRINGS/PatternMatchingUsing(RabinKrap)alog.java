//approach-RabinKrap


package patternsearchusingrabinkarpalgorithm;
import java.util.*;

public class PatternSearchUsingRabinKarpAlgorithm {
    static ArrayList<Integer> search(String pat, String txt)
    {
       int mod=(int)10e9 + 7;
       int m=pat.length();
       int n=txt.length();
       long sum=0;
       long desiredsum=0;
       for(int i=0;i<m;i++)
       {
           desiredsum+=(int)pat.charAt(i);//first find the sum of pat string
           desiredsum%=mod;
       }
       for(int i=0;i<m;i++)
       {
           sum+=(int)txt.charAt(i);//first find txt sum of length of pat length
           sum%=mod;
       }
       ArrayList<Integer> ans=new ArrayList<>();
       for(int i=m;i<=n;i++)//slide it one by one
       {
           if(desiredsum==sum)//if sum equal
           {
               int j=i-m;
               boolean isMatching=true;
               int k=0;
               for(;k<m;j++,k++)//check if chars are matching
               {
                   if(pat.charAt(k)!=txt.charAt(j))
                   {
                       isMatching =false;
                       break;
                   }
               }
               if(isMatching)
               {
                   ans.add(i-m+1);
               }
           }
           sum-=(int)txt.charAt(i-m);//remove i-m
           if(i<txt.length()){//add i;
               sum+=(int)txt.charAt(i);
               sum%=mod;
           }
       }
       if(ans.isEmpty())ans.add(-1);
       return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String txt=sc.next();
        String pat=sc.next();
        System.out.print(search(pat,txt));
        
    }
    
}
