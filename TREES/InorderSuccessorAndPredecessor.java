//approach -recursion
//Tc-O(n)

package inordersuccessororpredecessor;
import java.util.*;


public class InorderSuccessorOrPredecessor {
   static class TreeNode
   {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int val)
       {
           this.val=val;
       }
       
   }
   static TreeNode root;
   public static int InorderSuccessor(TreeNode root,TreeNode p)
   {
       TreeNode Successor=null;//for storing a value;
       while(root!=null)
       {
           if(root.val<=p.val)// if the root value is less than target node value go for right
           {
               root=root.right;
           }
           else//else go for left
           {
               Successor=root;//curr root may be a successor
               root=root.left;
           }
       }
       return Successor.val;
   }
   public static int  InorderPredecessor(TreeNode root,TreeNode p)
   {
       TreeNode Predercessor=null;
       while(root!=null)
       {
           if(root.val>=p.val)//if the root value is greater than target node go for left
           {
               
               root=root.left;
           }
           else//else gor for right
           {
               Predercessor=root;//curr root may be a predecessor
              root=root.right;
           }
       }
       return Predercessor.val;
   }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        root=new TreeNode(20);
        root.left=new TreeNode(8);
        root.right=new TreeNode(22);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(12);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(14);
        System.out.println("Inorder Successor of 9 is:"+InorderSuccessor(root,root.left.right.left));
        System.out.println("Inorder Predecessor of 9 is:"+InorderPredecessor(root,root.left.right.left));
    }
    
}
