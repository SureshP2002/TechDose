//leetcode-702
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();//creating an 2d list for storing the answer
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return l;//if root is null return empty list
        q.add(root);//adding curr rootnode
        while(!q.isEmpty())//it repeats untill q is empty
        {
            int size=q.size();//finding curr size of q
            List<Integer> a=new ArrayList<>();//creating a list to add elemnts at the current level
            for(int i=0;i<size;i++)
          {
              if(q.peek().left!=null)q.add(q.peek().left);//if there is a left node then add to q
              if(q.peek().right!=null)q.add(q.peek().right);//if there is a right node then add to q
                a.add(q.poll().val);//adding the val 
          }
            l.add(a);//add the curr list to 2d list
            
        }
        return l;
        
    }
}
