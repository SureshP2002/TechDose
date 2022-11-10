//TC:
   //Binary Search tree:
    //Insertion - O(N)
   //Traversal - O(N)
import java.util.*;
public class Main
{
    static class node{//node definition
        int data;
        node left,right;
        node(int val)
        {
            data=val;
            left=null;
            right=null;
        }
    }
    static node root=null;//initialy root is null
    void insert(node root,int val)
    {
       
       if(val<root.data)//if curr value is less than root value
       {
           if(root.left!=null)//if root.left is not null recursive call
           {
               insert(root.left,val);
           }
           else
           {
               root.left=new node(val);//else create a node
           }
       }
       else//if curr value is greater than root value
       {
           if(root.right!=null)//if root.right is not null
           {
               insert(root.right,val);//recurisve call
           }
           else
           {
               root.right=new node(val);//else create new node
           }
       }
        
        
    }
   
    void preorder(node root)//root-left-right
    {
        if(root==null)return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
        
    }
     void inorder(node root)//left-root-right
    {
        if(root==null)return;
        
        preorder(root.left);
        System.out.print(root.data+" ");
        preorder(root.right);
        
    }
     void postorder(node root)//left-right-root
    {
        if(root==null)return;
        
        preorder(root.left);
       preorder(root.right);
       System.out.print(root.data+" ");
        
    }
    void levelorder(node root)//level by level 
    {
      Queue<node> q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty())
       {
           node curr=q.poll();
           System.out.print(curr.data+" ");
           if(curr.left!=null)
           {
               q.add(curr.left);
           }
           if(curr.right!=null)
           {
               q.add(curr.right);
              
           }
           
           
       }
      
    
    }
    
	public static void main(String[] args) {
	Main s=new Main();//creatin an object
	node root=new node(34);//creating an rootnode with constructor value
	s.insert(root,56);//inserting
	s.insert(root,12);
	s.insert(root,89);
	s.insert(root,67);
	s.insert(root,90);
	s.preorder(root)
	System.out.println();
	s.inorder(root);
	System.out.println();
	s.postorder(root);
	System.out.println();
	s.levelorder(root);
	
	
	}
}
