//leetcode-199
//Approach-recursion
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
    public List<Integer> rightSideView(TreeNode root) {
       
        Queue<TreeNode> q=new LinkedList<>();//creating an queue
        List<Integer> ans=new ArrayList<>();//creating an list
        if(root==null)return ans;//if root is null return empty list
        q.add(root);//adding root at first
        //level order approach
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                if(i==size-1)//if size becomes last then we reached the node which is visible from right
                {
                    ans.add(q.peek().val);
                }
                    if(q.peek().left!=null)q.add(q.peek().left);
                    if(q.peek().right!=null)q.add(q.peek().right);
                    q.poll();
                
            }
        }
        return ans;
        
    }
}
