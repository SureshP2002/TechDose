//TC-O(N)

import java.util.*;
//creating an node
class Node{
    int data;
    Node next;
}

public class Main
{
    Node head=null;//making head to null
    Node temp=null;//making temp to null
    void append(int k)//making circular linked list
    {
        Node n=new Node();
        n.data=k;
        if(head==null)
        {
            head=n;
            temp=head;
        }
        else
        {
            temp.next=n;
            temp=temp.next;
        }
        n.next=head;
    }
    
    //finding the remaining element
    int getJosephusNode(int n,int k)
    {
        Node curr = head;
        Node prev = head;
        while(curr.next!=curr){
            int count=1;
            while(count<k){
                prev=curr;
                curr=curr.next;
                count++;
            }
            prev.next=curr.next;
            curr=curr.next;
        }
        return curr.data;
    }
    
	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int k=sc.nextInt();
	   Main s=new Main();
	   for(int i=1;i<=n;i++)
	   {
	       s.append(i);
	   }
	  int ans=s.getJosephusNode(n,k);
	  System.out.println(ans);
	  
	}
}
