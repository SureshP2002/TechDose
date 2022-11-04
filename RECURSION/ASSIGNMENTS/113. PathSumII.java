//leetcode-113
//approach-recursion


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
    List<List<Integer>> l;//creating an 2d list
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();//creating an list for storing elemnt
       if(root==null)//if no node then return empty list
       {
           return l;
       }
        FindPath(root,0,sum,ans);//calling function
        return l;
        
    }
    public void FindPath(TreeNode root,int currSum,int t,List<Integer> ans)
    {
       
       ans.add(root.val);//adding into the list
        currSum+=root.val;//incresing currSum
        if(root.left==null&&root.right==null)//if it is a leaf node
        {
            if(currSum==t)//if currSum is equal to target then..
            {
                l.add(new ArrayList<>(ans));//add to 2d list
                ans.remove(ans.size()-1);//removing the last element for finding another combination
                return;//break
            }
            else//if sum not equal
            {
                ans.remove(ans.size()-1);//remove last element
                return;
            }
        }
        if(root.left!=null)//if root.left is not null
        {
            FindPath(root.left,currSum,t,ans);//recurive call
        }
        if(root.right!=null)//if root.right is  not null
        {
            FindPath(root.right,currSum,t,ans);//recursive call
        
        }
        ans.remove(ans.size()-1);//removing last again;
        
      
        
        
    }
}
