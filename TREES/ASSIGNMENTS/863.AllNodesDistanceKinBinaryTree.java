//TC-O(N)
//approach-levelorder,bfs


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
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new LinkedList<>();//creating an Queue for levelOrder traversal
        q.add(root);//adding root first
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();//poll the curr element in the queue
            if(curr.left!=null)//if curr left is not null then add it
            {
                q.add(curr.left);
                map.put(curr.left,curr);//mark the parent for curr.left to curr
            }
            if(curr.right!=null)//if curr right is not null then add it
            {
                q.add(curr.right);
                map.put(curr.right,curr);//mark the parent for curr.right to right
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();//creating hashmap for parents for al nodes;
        markParents(root,map);//function call
        Map<TreeNode,Boolean> visited=new HashMap<>();//creating an visited hashmap for for avoiding duplicate paths
        Queue<TreeNode> q=new LinkedList<>();//creating an queue
        q.add(target);//adding target traversing fro target
        visited.put(target,true);//making true for curr node
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(level==k)break;//if level reaches k then break
            level++;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                //checking for curr left and making them an visited
                if(curr.left!=null&&visited.get(curr.left)==null)
                {
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                 //checking for curr right and making them an visited
                if(curr.right!=null&&visited.get(curr.right)==null)
                {
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                 //checking for parent(up)and making them an visited
                if(map.get(curr)!=null&&visited.get(map.get(curr))==null)
                {
                    q.add(map.get(curr));
                    visited.put(map.get(curr),true);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty())
        {
            res.add(q.poll().val);//finally adding the remaining  elemnts to the list
        }
          return res;
        
    }
}
