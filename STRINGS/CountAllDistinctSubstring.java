//tc-O(n^2)



package countalldistinctsubstrings;
import java.util.*;


public class CountAllDistinctSubstrings {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Set<String> set=new HashSet<>();//creating hashSet
        for(int i=0;i<=s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                set.add(s.substring(i,j));//adding in set for avoiding duplicates
            }
        }
        System.out.print(set.size());//printing size;
       
    }
    
}
