//methode1-Recursion
//Tc-O(n)
//SC-O(n)


package Treetraversalmethod1;



public class TreeTraversalMethod1 {
     static class TreeNode{//definition
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int val)
         {
             this.val=val;
         }
     }
     static TreeNode root;
     static void inorder(TreeNode root)
     {
         if(root==null)return;
         inorder(root.left);
         System.out.print(root.val+"->");
         inorder(root.right);
     }
     static void preorder(TreeNode root)
     {
         if(root==null)return;
         System.out.print(root.val+"->");
         preorder(root.left);
         preorder(root.right);
     }
     static void postorder(TreeNode root)
     {
         if(root==null)return;
         postorder(root.left);
         postorder(root.right);
         System.out.print(root.val+"->");
     }
    
    public static void main(String[] args) {
        
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        System.out.println("Inorder");
        inorder(root);
        System.out.println("\npreorder");
        preorder(root);
        System.out.println("\npostorder");
        postorder(root);
        
    }
    
}
