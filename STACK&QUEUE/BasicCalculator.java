//leetcode-224
//TC-O(N)
 //approach-stack;



class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<Integer>();//creating an stack
        int result=0;//inittial result 0
        int sign=1;// sign positive
        int number=0;//initial number 0
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))//if it is digit
            {
                number=number*10+(int)(c-'0');// forming numbers
                
            }
            else if(c=='+')//if plus comes
            {
                result+=(sign*number);//multiply number with sign and add to result
                number=0;//make number to 0;
                sign=1;//make sign to positive
            }
            else if(c=='-')//if negative comes
            {
                result+=(sign*number);//multiply number with sign and add to result
                number=0;//make number to 0;
                sign=-1;//make sign to 0;
            }
            else if(c=='(')//if open paranthesis comes
            {
                st.push(result);//adding result to the stack;
                st.push(sign);//adding sign to the stack
                sign=1;//making sign to positive;
                result=0;//calculate new result inside the parenthesis
                
            }
            else if(c==')')//if closing bracket comes;
            {
                result+=sign*number;//multiply number with sign and add to result
                number=0;
                result*=st.pop();//multiply stack prev sign with curr result
                result+=st.pop();//adding result with stacks result;
            }
        }
        if(number!=0)result+=number*sign;//dinally if  number is not 0 add it to result;
        return result;
        
    }
}
