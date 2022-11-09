//leetcode-301
//approach-recursion

class Solution {
    Set<String> set=new HashSet<>();//set for removing duplicate combinations
    List<String> res=new ArrayList<>();//crating an arraylist
    public List<String> removeInvalidParentheses(String s) {
        int n=invalidparen(s);//finding no of invalid parenthesis
        findCombi(n,s,res);//function call
        return res;
    }
    public int invalidparen(String s)
    {
        Stack<Character> st=new Stack<>();//creating stack
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')//if open bracket means add
            {
                st.push('(');//push
            }
            else if(s.charAt(i)==')')//if close bracket means
            {
                if(!st.isEmpty()&&st.peek()=='(')//checking if top of the stack contains open bracket
                {
                    st.pop();//poping it
                }
                else//else adding it to stack
                {
                    st.push(')');
                }
                
                
            }
        }
        return st.size();//size(no of invalid parenthesis)
    }
    public void findCombi(int n,String s,List<String> res)
    {
        if(set.contains(s))//if the combinations already available return
        {
            return;
        }
        else
        {
            set.add(s);//else add it to set
        }
        if(n==0)//if n comes to zero means dupliactes removed for currstr
        {
            if(invalidparen(s)==0)//if there is no invalid paren the curr str add it to result
            {
                res.add(s);
            }
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String left=s.substring(0,i);//left sub
            String right=s.substring(i+1);//right sub
            findCombi(n-1,left+right,res);//recursive call
        }
    }
}
