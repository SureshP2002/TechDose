//leetcode-155
//TC-O(1)

class MinStack {
   int min;
    Stack<Integer> stack=new Stack<Integer>();
    public MinStack() {
        this.min=Integer.MAX_VALUE;//keeping min is large
    }
    
    public void push(int val) {
        if(val<=min)//if curr val is less than min
        {
            stack.push(min);//adding prev min
            min=val;//update curr min
        }
        stack.push(val);//pushing val
        
    }
    
    public void pop() {
        if(stack.pop()==min)//if poping element is min
        {
            min=stack.pop();//then remove next min;
        }
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
