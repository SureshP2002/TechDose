//leetcode-103;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();//creating an 2d list
        Queue<TreeNode> q=new LinkedList<>();//creating queue
        if(root==null)return l;//if root is null return
        q.add(root);//first adding the root node
        int c=0;
        while(!q.isEmpty())
        {
            int size=q.size();//finfing current q size
            List<Integer> ans=new ArrayList<>();//creating an arraylist
            c++;
            for(int i=0;i<size;i++)
            {
                if(q.peek().left!=null)q.add(q.peek().left);//if left node available add it
                if(q.peek().right!=null)q.add(q.peek().right);//if right node is available add it
                ans.add(q.poll().val);//adding to the list
            }
            if(c%2==0)
            {
                Collections.reverse(ans);//reversing for(zigzag);
            }
            l.add(ans);//adding to the list;
        }
        return l;
        
    }
}
