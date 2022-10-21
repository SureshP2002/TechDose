//leetcode-227
//TC-O(N);

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<Integer>();//creating an stack
        int currnum=0;
        char operation='+';//initial opeartion is plus
       for(int i=0;i<s.length();i++)
       {
           char ch=s.charAt(i);
           if(Character.isDigit(ch))//if it is a digit
           {
             currnum=currnum*10+ch-'0';//number
           }
           if(!Character.isDigit(ch)&&!Character.isWhitespace(ch)||i==s.length()-1)//if it is not a number
           {
               if(operation=='+')
               {
                   stack.push(currnum);//if it is plus means push the cuur num
               }
               else if(operation=='-')
               {
                   stack.push(-1*currnum);//if it is negative means push the negative of curr numm 
               }
               else if(operation=='*')
               {
                   stack.push(stack.pop()*currnum);//if it is multiplication then  pop prev number and multiply with curnnum
               }
               else if(operation=='/')
               {
                   stack.push(stack.pop()/currnum);//if it is division then pop prev number and divid with currnum
               }
               currnum=0;
               operation=ch;//change the operation to new sign
           }
       }
        int result=0;
        while(!stack.empty())
        {
            result+=stack.pop();//adding all the numbers
        }
        return result;
        
    }
}
