//leetcode-114
//approach-recursion



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
    TreeNode prev=null;//initially prev is null
    public void flatten(TreeNode root) {
      if(root==null)return;//if root is null return
        flatten(root.right);//first traverse to last right
        flatten(root.left);//then to traverse
        root.left=null;//making left as null
        root.right=prev;//making currRight to prev
        prev=root;//making prev as curr root;
    }
}
