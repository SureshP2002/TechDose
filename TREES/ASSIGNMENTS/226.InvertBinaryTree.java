//leetcode-226
//TC-O(N)


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
    public TreeNode invertTree(TreeNode root) {
       if(root==null)return null;//if the root is null then return
        TreeNode temp=root.left;//swaping left and right child and its descendants
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);//left recursive call
        invertTree(root.right);//right recursive call
        return root;
    }
    
}
