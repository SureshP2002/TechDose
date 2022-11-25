//methode2-Using stack
//Tc-O(N)
//SC-O(N)


package treetraversalmethode2;
import java.util.*;

public class TreeTraversalMethode2 {
    static class TreeNode{//definition
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int val)
         {
             this.val=val;
         }
     }
     static TreeNode root;
     static void inorder(TreeNode root)
     {
         Stack<TreeNode> st=new Stack<>();//creating stack
         TreeNode curr=root;
         while(!st.isEmpty()||curr!=null)
         {
             while(curr!=null)//traversing to left first
             {
                 st.push(curr);//adding to stack
                 curr=curr.left;
             }
             curr=st.peek();//taking curr node
             st.pop();//removing it
             System.out.print(curr.val+"->");//printing
             curr=curr.right;//checking for right
         }
     }
     static void preorder(TreeNode root)
     {
         Stack<TreeNode> st=new Stack<>();//creating the stack
         TreeNode curr=root;
         while(curr!=null||!st.isEmpty())
         {
             while(curr!=null){//first moving to left
                 st.push(curr);//adding currnode
                 System.out.print(curr.val+"->");//printing the currnode value
                 curr=curr.left;
             }
             curr=st.pop();//removing curr node
             curr=curr.right;//going for right
         }
         
     }
     static void postorder(TreeNode root)
     {
         Stack<TreeNode> st=new Stack<>();//creating an stack;
         
         TreeNode curr=root;//making currnode as root
         while(!st.isEmpty()||curr!=null)
         {
             if(curr!=null)//going for right if curr is not null
             {
                 st.push(curr);
                 curr=curr.left;
             }
             else//once curr comes for null it means left finishes
             {
                 TreeNode temp=st.peek().right;//making temp as stack top.right(going for right)
                 if(temp==null)//once in the right call null comes 
                 {
                     temp=st.peek();//taking curr node
                     st.pop();//removing it
                     System.out.print(temp.val+"->");//printing val because it encounter for third time
                     while(!st.isEmpty()&&temp==st.peek().right)//then traversing back for root call(if stack top.right is temp)
                     {
                         temp=st.peek();//taking the curr temp
                         st.pop();///reoving it
                         System.out.print(temp.val+"->");//printing
                     }
                     
                 }
                 else//if not null go for right
                 {
                     curr=temp;//making curr as temp
                 }
                 
             }
           
         }
         
     }
    
    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        System.out.println("Inorder");
        inorder(root);
        System.out.println("\npreorder");
        preorder(root);
        System.out.println("\npostorder");
        postorder(root);
