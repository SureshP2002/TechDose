//approach-recursion


package tree;
import java.util.*;
class TreeNode//class definition
{
    int data;
    TreeNode left,right;
    TreeNode(int val)
    {
        data=val;
        left=null;
        right=null;
    }
}


public class Tree {
    static TreeNode root=null;//root is null initially
     static TreeNode BuildTree(int arr[],int index)
    { 
        TreeNode root=null;
        if(index<arr.length)
        {
            root=new TreeNode(arr[index]);
            root.left=BuildTree(arr,2*index);//left index 2*i
            root.right=BuildTree(arr,2*index+1);//right index 2*i+1
        }
        return root;
    }
   static  void preorder(TreeNode root)
    {
        if(root!=null)
        {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    static void postorder(TreeNode root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }


    
    public static void main(String[] args) {
       Scanner s =new Scanner(System.in);
       int arr[]=new int[]{0,1,2,3,4,5};//array
       Tree tree=new Tree();//creating an object
       tree.root=BuildTree(arr,1);//creating root node
        System.out.println("Preorder");
        preorder(tree.root);
        System.out.println("\nInorder");
        inorder(tree.root);
        System.out.println("\nPostorder");
        postorder(tree.root);
    }
    
}
