//leetcode-1448
//approach-recursion;
//TC_O(N)


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
    int count=0;
    public int goodNodes(TreeNode root) {
    Good(root,Integer.MIN_VALUE);//function call
    return count;
        
    }
    public void Good(TreeNode root,int max)//preorder approach
    {
        
        if(root==null)return ;//if root is null return back
        if(root.val>=max)count++;//if curr val greater than max count++;
        max=Math.max(max,root.val);//finding maximum with curr val
        Good(root.left,max);//left call
        Good(root.right,max);//right call
      
    }
}
