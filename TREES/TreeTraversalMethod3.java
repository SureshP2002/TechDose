//methode2-MorrisTraversal
//TC-O(N)
//SC-O(1)

package treetraversalmethode3;
import java.util.*;


public class TreeTraversalMethode3 {
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
         TreeNode curr=root;
         while(curr!=null)
         {
             if(curr.left==null)
             {
                 System.out.print(curr.val+"->");
                 curr=curr.right;
             }
             else
             {
                 TreeNode predicessor=curr.left;
                 while(predicessor.right!=null&&predicessor.right!=curr)
                 {
                     predicessor=predicessor.right;
                 }
                 if(predicessor.right==null)
                 {
                     predicessor.right=curr;
                     curr=curr.left;
                 }
                 else if(predicessor.right==curr)
                 {
                     predicessor.right=null;
                     System.out.print(curr.val+"->");
                     curr=curr.right;
                 }
             }
         }
     }
     static void preorder(TreeNode root)
     {
         TreeNode curr=root;
         while(curr!=null)
         {
             if(curr.left==null)
             {
                 System.out.print(curr.val+"->");
                 curr=curr.right;
             }
             else
             {
                 TreeNode predicessor=curr.left;
                 while(predicessor.right!=null&&predicessor.right!=curr)
                 {
                     predicessor=predicessor.right;
                 }
                 if(predicessor.right==null)
                 {
                     predicessor.right=curr;
                     System.out.print(curr.val+"->");
                     curr=curr.left;
                 }
                 else if(predicessor.right==curr)
                 {
                     predicessor.right=null;
                     curr=curr.right;
                 }
             }
         }
     }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
        
    }
    
}
