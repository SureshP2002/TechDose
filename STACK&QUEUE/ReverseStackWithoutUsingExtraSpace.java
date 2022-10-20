//TC-O(1)



import java.util.*;
public class Main
{
    static Stack<Integer> st=new Stack<>();//creating an stack
	public static void main(String[] args) {
		
		st.push(10);//pushing the elements
		st.push(20);
		st.push(30);
		st.push(40);
		System.out.println(st);//printing before reverse
		reverse();//reversing
		System.out.println(st);//printing after reverse
	}
	static void reverse()
	{
	    if(!st.isEmpty())//recursive call untill stack is empty
	    {
	    int temp=st.peek();//storing the value
	    st.pop();
	    reverse();
	    Insert(temp);//adding the stored value
	    }
	}
	static void Insert(int val)
	{
	    if(st.isEmpty())//if stack is empty add the curr value
	    {
	        st.push(val);
	    }
	    else{
	    int t=st.peek();
	    st.pop();
	    Insert(val);//recursivly adding
	    st.push(t);
	    }
	}
}
