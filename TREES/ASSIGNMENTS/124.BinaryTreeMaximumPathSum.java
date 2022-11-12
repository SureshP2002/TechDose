//leetcode-124
//TC-O(N)
//MAXPATH POSTORDER approach

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
    int result=Integer.MIN_VALUE;//leeping initial rsult as INT_MIN
    public int maxPathSum(TreeNode root) {
        maxSum(root);//function call
        return result;
    }
    public int maxSum(TreeNode root)
    {
    if(root==null)return 0;//if root is null return 0
        //postordertraversal
    int left=maxSum(root.left);//left recursive call
    int right=maxSum(root.right);//right recursive call
    int case1=Math.max(Math.max(left,right)+root.val,root.val);//case1 currnode val is in the path
    int case2=Math.max(left+right+root.val,case1);//case2 curr node is root of maxPath so left+right+root.val,with case1
    result=Math.max(case2,result);//finding result comapring pre PathSum and CurrPathSum
    return case1;//return case because it can only be extent
    }
}
