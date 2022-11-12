//leetcode-297
//approach-recursion
//TC-O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public TreeNode toNode(String node[],int i)
    {
        if(i>=node.length||node[i].equals("*")||",".equals(node[i]))
        {
            return null;
        }
        return new TreeNode(Integer.parseInt(node[i]));
    }
    public TreeNode decode(String data)
    {
        String node[]=data.split(",");//spliting them with comma
        Queue<TreeNode> q=new LinkedList<>();//creating an Queue
        int index=0;
        TreeNode root=toNode(node,index++);//converting curr String value toNode
        q.add(root);//adding to root
        while(!q.isEmpty())
        {
            int size=q.size();//finding current size
            for(int i=0;i<size&&index<node.length;i++)
            {
                TreeNode temp=q.poll();//polling first
                temp.left=toNode(node,index++);//creating an node to temp.left
                temp.right=toNode(node,index++);//creating an node to temp.right
                if(temp.left!=null)//if temp.left is not null
                    q.add(temp.left);//add to queue
                if(temp.right!=null)//if temp right is not null
                    q.add(temp.right);//add to queue
            }
        }
        return root;
        
    }
    public String encode(TreeNode root)
    {
        
        //levelorder approach
        Queue<TreeNode> q=new LinkedList<>();//creating an Queue
        String s="";//emptyString
        q.add(root);//adding root
        while(!q.isEmpty())
        {
            int size=q.size();//finding curr size
            for(int i=0;i<size;i++)
            {
              TreeNode temp=q.poll();//polling fornt element from queue
                if(temp!=null)//if curr node is not null
                {
                    s+=temp.val;//concat to val to string
                    s+=",";//after that concat ,
                    q.add(temp.left);//adding left and right values
                    q.add(temp.right);
                }
                else//if it is null
                {
                    s+="*";//adding star
                    s+=",";//after that adding comma
                }
              
                
            }
        }
        //System.out.print(s);
        return s;
    }

   
   
     // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)//if root is null return * because we are making null as * in the program
            return "*";
        return encode(root);//function call
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if("*".equals(data))//if the coming string conatains only star return null
            return null;
        return decode(data);//function call
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
