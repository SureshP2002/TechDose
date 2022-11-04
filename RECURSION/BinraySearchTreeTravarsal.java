//recursive approach

package bst;
import java.util.*;

class node{//class definition
    int data;//it contains a data
    node left;//left pointer 
    node right;//right pointer
    node(int val)//constructor
    {
        this.data=val;
        this.left=null;
        this.right=null;
    }
}
public class Bst {
    static node root=null;//initially root is null
     static void insert(int val)
     {
         
         if(root==null)//if root is null 
         {
             root=new node(val);//then make root node as first node
         }
         else
         {
             add(root,val);//if other values comes
         }
     }
    static void add(node root,int val)
     {
         
         if(val<root.data)//if the curr value is lesser than the roots.data
         {
             if(root.left==null){//checking if left of root is null
                 root.left=new node(val);//creating new node and adding value
                 return;
             }
             add(root.left,val);// recuruive call for root.left
         }
         else if(val>root.data)//if the curr value is greater than roots.data
         {
             if(root.right==null)//checking if right of root is null
             {
                 root.right=new node(val);//creating new node and adding value
                 return;
             }
             add(root.right,val);//recursive call for root.right;
         }
         
     }
     
     static void preordertraversal(node root)//<-Root--left---right->
     {
         if(root==null)return;
         System.out.print(root.data+" ");
         preordertraversal(root.left);
         preordertraversal(root.right);
     }
    
     static void inordertraversal(node root)//<-left--root--right->
     {
         if(root==null)return;
         inordertraversal(root.left);
         System.out.print(root.data+" ");
         inordertraversal(root.right);
     }
     
     static void postordertraversal(node root)//<--left-right-root->
     {
         if(root==null)return;
         postordertraversal(root.left);
         postordertraversal(root.right);
         System.out.print(root.data+" ");
     }
   
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
     
       int n=sc.nextInt();//getting an input
       for(int i=0;i<n;i++)
       {
           int data=sc.nextInt();//getting data to build bst
           insert(data);//inserting elements in the binary search tree
       }
       System.out.println("Preorder");
       preordertraversal(root);
       System.out.println("\ninorder");
       inordertraversal(root);
       System.out.println("\nPostorder");
       postordertraversal(root);
    }
    
}
