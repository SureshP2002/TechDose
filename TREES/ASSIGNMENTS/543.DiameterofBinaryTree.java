//leetcode-543
//approach-recursion
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
    int count=0;//initializing
    public int diameterOfBinaryTree(TreeNode root) {
        Count(root);//function call
        return count;
    }
    public int  Count(TreeNode root)
    {
        if(root==null)return 0;//if root is null return 0;
        int left=Count(root.left);//left call
        int right=Count(root.right);//right call
        count=Math.max(count,left+right);//finding count value at every subtree(height=left+right)
        return 1+Math.max(left,right);//finally returning max (left ,right) +1;
    }
}
