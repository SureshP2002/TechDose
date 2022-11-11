//leetcode-1382
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
    List<TreeNode> l=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);//finding inorder
        return BalancedTree(0,l.size()-1);//function call
        
    }
    public void inorder(TreeNode root)
    {
        if(root==null)return;
        inorder(root.left);//left--root--right
        l.add(root);//adding the root
        inorder(root.right);
        
    }
    public TreeNode BalancedTree(int left,int right)
    {
        if(left>right)return null ;
        int mid=left+(right-left)/2;//finding mid
        TreeNode root=l.get(mid);//creating  an root and adding mid value
        root.left=BalancedTree(left,mid-1);//root's left is left and mid-1
        root.right=BalancedTree(mid+1,right);//root's right is mid+1 and right
        return root;//returning root
        
    }
    
}
