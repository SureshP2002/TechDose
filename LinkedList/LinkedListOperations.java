package lnkdlist;
import java.util.*;
import java.lang.*;

class node{
    int data;
    node next;
}

public class Lnkdlist {
    node head=null;
    node temp=null;
    void insertAtEnd(int val)
    {
        node newNode=new node();
        newNode.data=val;
        if(head==null)
        {
            head=newNode;
            temp=newNode;
        }
        else
        {
            temp.next=newNode;
            temp=temp.next;
        }
        
    }
    void insertAtBegining(int val)
    {
        
        node newNode=new node();
        newNode.data=val;
        if(head==null)head=newNode;
        newNode.next=head;
        head=newNode;
    }
    void insertAtposition(int pos,int val)
    {
        node newNode=new node();
        newNode.data=val;
        if(pos==1)
        {
            newNode.next=head;
            head=newNode;
        }
        else
        {
            node ctr=head;
            for(int i=1;i<pos-1;i++)
            {
                
                ctr=ctr.next;
            }
           newNode.next=ctr.next;
           ctr.next=newNode;
        }
    }
    void deleteAtBegin(int pos)
    {
        if(head!=null)
        {
            head=head.next;
        }
        else
        {
            System.out.println("Empty");
        }
        
    }
    void deleteAtPosition(int pos)
    {
        node ctr=head;
        node prev=ctr;
        for(int i=1;i<pos;i++)
        {
            prev=ctr;
            ctr=ctr.next;
        }
        prev.next=ctr.next;
    }
    void deleteAtEnd()
    {
        if(head==null)
        {
            System.out.println("Empty");
        }
        else if(head.next==null)
        {
            head=null;
        }
        else
        {
            node c=head;
            while(c.next.next!=null)
            {
                c=c.next;
            }
            c.next=null;
            
        }
    }
    void reverseList()
    {
        node prev=null;
        node curr=head;
        node next=head.next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    void display()
    {
        node ptr=head;
        while(ptr!=null)
        {
            System.out.print(ptr.data+"->");
            ptr=ptr.next;   
        }
        System.out.println();
        
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
       Lnkdlist l=new Lnkdlist();
       l.insertAtEnd(10);
       l.insertAtEnd(20);
       l.insertAtEnd(30);
       l.insertAtEnd(40);
       l.display();
       l.insertAtBegining(5);
       l.insertAtBegining(7);
       l.display();
       l.insertAtposition(2,9);
       l.insertAtposition(3,12);
       l.display();
       l.deleteAtBegin(1);
       l.display();
       l.deleteAtPosition(3);
       l.display();
       l.deleteAtEnd();
       l.display();
       l.reverseList();
       l.display();
    }
    
    
}
