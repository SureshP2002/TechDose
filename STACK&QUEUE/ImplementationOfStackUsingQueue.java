//leetcode-225


class MyStack {
   Queue<Integer> q;

    public MyStack() {
        this.q=new LinkedList<Integer>();//creating an queue
    }
    
    public void push(int x) {
        q.add(x);//adding elements
        for(int i=0;i<q.size()-1;i++)
        {
            q.add(q.poll());//adding front elemenst again upto size -1
        }
    }
    
    public int pop() {
        return q.poll();
       
        
    }
    
    public int top() {
        return q.peek();
       
        
    }
    
    public boolean empty() {
        return q.isEmpty();
       
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
