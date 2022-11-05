//leetcode-437
//approach-recursion backtracking


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
    List<Integer> l=new ArrayList<>();//creating the list for adding elements
    int count=0;//for count no of paths
    public void GetPaths(TreeNode root,int sum)
    {
        if(root==null)//if the root comes to null function return
        {
            return;
        }
        l.add(root.val);//adding at each function recursive call
        long currSum=0;
        for(int i=l.size()-1;i>=0;i--)//add currSum
        {
            currSum+=(long)l.get(i);
            if(currSum==sum)//if the currSUm is equal to targetsum then increamnet count
            {
                count++;
            }
        }
        GetPaths(root.left,sum);//recursive call for left of the tree
        GetPaths(root.right,sum);//recursive call for right of the tree
        l.remove(l.size()-1);//at each function while bactracking the recently added element must be removed
    }
    public int pathSum(TreeNode root, int targetSum) {
        GetPaths(root,targetSum);//function call
        return count;
        
        
    }
}
