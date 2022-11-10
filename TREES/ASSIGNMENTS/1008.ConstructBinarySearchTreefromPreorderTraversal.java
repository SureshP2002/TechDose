//leetcode-1008
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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder,Integer.MAX_VALUE);//returning the tree
    }
    public TreeNode buildTree(int[]preorder,int bound)
    {
        if(index==preorder.length||preorder[index]>bound)//if index reaches preorder length or curr preorder[index] is greater than guven bound means return null
        {
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[index]);//creating node
        index++;//increamenting the index
        root.left=buildTree(preorder,root.val);//root.left (bound will be curr root.val)
        root.right=buildTree(preorder,bound);//root.right (bound will be previous bound)
        return root;
    }
}
