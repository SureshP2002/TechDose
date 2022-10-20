//leetcode-232
//TC-O(N);

class MyQueue {
    Stack<Integer> stack1;//creating two stacks
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1=new Stack<>();
        this.stack2=new Stack<>();
        
    }
    
    public void push(int x) {
        stack1.push(x);//adding elements in the stack1
        
    }
    
    public int pop() {
        while(stack1.size()>1)//pop elements from stack 1 and put to stack 2 with balance 1 element
        {
            int back=stack1.pop();
            stack2.push(back);
        }
        int val=stack1.pop();//storing the element
        while(!stack2.empty())
        {
            int back=stack2.pop();
            stack1.push(back);
        }
        return val;
        
    }
    
    public int peek() { 
        while(stack1.size()>0)//peek elements from stack 1 and put to stack 2 
        {
            int front=stack1.pop();
            stack2.push(front);
        }
        int val=stack2.peek();//taking top element
        while(!stack2.empty())
        {
            int front=stack2.pop();
            stack1.push(front);
        }
        return val;
    }
    
    public boolean empty() {
        return stack1.empty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
