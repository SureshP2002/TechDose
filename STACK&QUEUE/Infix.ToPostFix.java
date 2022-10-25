//approach-stack;

package infixtopostfix;
import java.util.*;

public class InfixToPostFix {
    static String Evaluate(String exp){
        int len=exp.length();
        Map<Character,Integer> precidence=new LinkedHashMap<>();
        precidence.put('+', 1);
        precidence.put('-',1);
        precidence.put('*',2);
        precidence.put('/',2);
        precidence.put('%',2);
        precidence.put('^',3);
        Stack<Character> st=new Stack<>();
        String postFix="";
        for(int i=0;i<len;i++)
        {
            char ch=exp.charAt(i);
            if(ch>='a'&&ch<='z')
            {
                postFix+=ch+"";
            }
            else if(ch=='(')
            {
                st.push('(');
            }
            else if(ch==')')
            {
                while(!st.isEmpty()&&st.peek()!='(')
                {
                    postFix+=st.pop()+"";
                }
                st.pop();
            }
            else 
            {
                while(!st.isEmpty()&&st.peek()!='('&&precidence.get(st.peek())>=precidence.get(ch))
                {
                    postFix+=st.pop()+"";
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty())
        {
            postFix+=st.pop()+"";
        }
        return postFix;
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String exp=sc.next();
        System.out.println(Evaluate(exp));
    }
    
}
