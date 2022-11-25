//approach-recursion
//TC-O(n)

package foldabletree;
import java.util.*;


public class FoldableTree {
     static class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int val)
         {
             this.val=val;
         }
     }
     static boolean isFoldableTree(TreeNode root)
     {
         if(root==null)return true;
         return CheckFold(root.left,root.right);//sending left and right subtree
     }
     static boolean CheckFold(TreeNode node1,TreeNode node2)
     {
         if(node1==null&&node2==null)return true;//if both are null return true
         if(node1==null||node2==null)return false;//if any one is null we cant fold return false
         return CheckFold(node1.left,node2.right)&&CheckFold(node1.right,node2.left);//recursive call for left and right
         
     }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.left.right=new TreeNode(9);
        root.right.left=new TreeNode(11);
        root.right.right=new TreeNode(12);
        root.left.left=new TreeNode(11);
        System.out.print(isFoldableTree(root)?"Foldable":"Not Foldable");
    }
    
}
