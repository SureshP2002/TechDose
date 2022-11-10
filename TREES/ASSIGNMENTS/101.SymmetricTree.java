//leetcode-101
//TC-O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetr(root.left,root.right);//caaling function 
        
    }
    public boolean isSymmetr(TreeNode l,TreeNode r)
    {
        if(l==null&&r==null)return true;//if l and r is null return true because end of the tree is reached without mismatch
        if(l==null||r==null)return false;//if l or r becomes false return false;
        if(l.val!=r.val)return false;//if val of l is not equal to val of r return false
        return isSymmetr(l.left,r.right)&&isSymmetr(l.right,r.left);//recursive call for both left and reight subtree;
    }
}
