//leetcode-285
//TC-O(N)
//APPRAOCh-RECURSION

import java.util.*;
class TreeNode{//node definition
    int data;
    TreeNode left,right;
    TreeNode(int val)
    {
        this.data=val;
    }
}
public class Main
{
    static TreeNode root;
    static TreeNode res;
    static void inorderSuccessor(TreeNode root,TreeNode parent)
    {
        if(root==null)return;//if root is null return
        
        inorderSuccessor(root.left,parent);//left call
        if(root.data>parent.data&&res==null)//if parent node is less than curr node in inorder tarversal (answer is found )return
        {
            res=root;
            return;
        }
        inorderSuccessor(root.right,parent);
        
    }
	public static void main(String[] args) {
		root = new TreeNode(20);//inserting values;
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right=new TreeNode(22);
        inorderSuccessor(root,root.left.right);//finding inorderSuccessor
        System.out.println(res.data);
        res=null;
        inorderSuccessor(root,root.right);
        if(res==null)System.out.println("null");
        else System.out.println(res.data);
        
	}
}
