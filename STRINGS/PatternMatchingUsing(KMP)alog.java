//approach-kmp

package patternsearchusingkmp;
import java.util.*;


public class PatternSearchUsingKmp {

    static ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=txt.length();
        int m=pat.length();
        int lps[]=new int[m];
        lps=filllps(pat,lps);//finding lps
        int i=0,j=0;
        while(i<n)
        {
            if(pat.charAt(j)==txt.charAt(i))//if both char same incremendt both index
            {
                i++;
                j++;
            }
            if(j==m){//if  j reaches pattern end then one pattern in txt is found
                ans.add(i-j+1);
                j=lps[j-1];
            }
            else if(i<n&&pat.charAt(j)!=txt.charAt(i)){//if both char not equal
                if(j==0)i++;//if j is 0 move i
                else j=lps[j-1];//else moce back j
            }
        }
        return ans;
    }
    public static int[] filllps(String pattern,int lps[]) {
        int m = pattern.length();
        int len = 0; // Length of the previous longest prefix suffix

        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                    i--;
                } else {
                    lps[i] = 0;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String txt=sc.next();
        String pat=sc.next();
        System.out.print(search(pat,txt));
    }
    
}
