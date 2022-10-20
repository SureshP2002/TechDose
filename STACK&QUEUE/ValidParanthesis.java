//leetcode-20
//TC-O(N)


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();//creating an stack
        char c[]=s.toCharArray();//converting to an char array
        for(char ch:c)
        {
            if(ch=='(')//if open bracket comes adding close bracket
                stack.push(')');
            else if(ch=='{')
                stack.push('}');
            else if(ch=='[')
                stack.push(']');
            else if(stack.isEmpty()||stack.pop()!=ch  )//if close bracket come poping from stack and checking if it is equal
                return false;
        }
        
        return stack.isEmpty();//if stack is empty
    }
}
