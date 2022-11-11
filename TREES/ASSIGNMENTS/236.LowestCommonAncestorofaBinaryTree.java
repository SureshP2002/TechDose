//leetcode-236
//TC-O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null)//base condition incase tha nodes p or q is found return curr root
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);//left recursive call
        TreeNode right=lowestCommonAncestor(root.right,p,q);//right recursive call
        
        if(left!=null&&right!=null)return root;//if both left and right is notnull then p and q is notfound
       return left==null?right:left;//if left is null then return right else return left
        
    }
}
