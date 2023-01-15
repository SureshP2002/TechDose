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
    static int[] filllps(String pat,int []lps)
    {
        int m=pat.length();
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<m)
        {
            if(pat.charAt(i)==pat.charAt(len))//if both char same in pattern string
            {
                len++;
                lps[i]=len;//add count
                i++;
            }
            else//if not
            {
                if(len==0)//len is 0 
                {
                    lps[i]=0;
                    i++;
                }
                else
                {
                    len=lps[len-1];
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
