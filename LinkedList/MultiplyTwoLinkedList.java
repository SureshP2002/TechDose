//Tc-O(N)



public class MultiplyTwoList
{
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int val)
        {
            this.data=val;
            this.next=null;
        }
    }
    static int Multiply(Node l1,Node l2)
    {
        int num1=0;
        int num2=0;
        while(l1!=null&&l2!=null)
        {
            if(l1!=null)
            {
                num1=num1*10+l1.data;
                l1=l1.next;
            }
            if(l2!=null)
            {
                num2=num2*10+l2.data;
                l2=l2.next;
            }
        }
        return num1*num2;
    }
	public static void main(String[] args) {
	    Node l1=new Node(10);
	    l1.next=new Node(3);
	    Node l2=new Node(1);
	    l2.next=new Node(2);
	    System.out.println(Multiply(l1,l2));
		
	}
}
