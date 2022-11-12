//leetcode-993
//approach-levelOrder
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
    Queue<TreeNode> q=new LinkedList<>();//creating an Queue
      q.add(root);//adding root
        //level order approach
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList<>();//crwating an arraylist
            int size=q.size();//finding curr size of q
            for(int i=0;i<size;i++)
            {
               if(q.peek().left!=null)q.add(q.peek().left);//if left not null add to q
               if(q.peek().right!=null)q.add(q.peek().right);//if right not null add to q
                l.add(q.peek().val);//add the curr level values to list
                if(q.peek().left!=null&&q.peek().right!=null)
                {
                    //if x and y are under same parent return false
                    if((q.peek().left.val==x&&q.peek().right.val==y)||(q.peek().left.val==y&&q.peek().right.val==x))
                    {
                        return false;
                    }
                }
               
                q.pop();//removing prev node from queue
                
            }
            if(l.contains(x)&&l.contains(y))//if value area at the same level return true
                return true;//
        }
        return false;
    }
    
}
