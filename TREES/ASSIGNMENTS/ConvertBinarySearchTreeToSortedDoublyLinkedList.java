//TC-O(N)

package convertbinarysearchtreetosortedlinkedlist;
import java.util.*;


public class ConvertBinarySearchTreeToSortedLinkedList {
   static class TreeNode//defining an treeNode
   {
       int data;
       TreeNode left,right;
       TreeNode(int val)
       {
           this.data=val;
       }
   }
   static node head;
   static class node{//defining the node
       int data;
       node next,prev;
       node(int val)
       {
           this.data=val;
       }
   }
   static void inorder(TreeNode root)//inorder traversal for creating an DLL
   {
       if(root==null)return;
        inorder(root.left);
            node nn = new node(root.data);
            if (head == null) {
                head = nn;
                head.next = nn;
                head.prev = nn;
            } else {
                node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = nn;
                nn.prev = temp;
                nn.next = head;
                head.prev = nn;
            }
            inorder(root.right);
       
              
   }
   static List<Integer> res=new ArrayList<>();//creating an list
    static void display()
    {
       node temp=head;
       while(temp.next!=head)
       {
           res.add(temp.data);
           temp=temp.next;
       }
       res.add(temp.data);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode treeroot = new TreeNode(4);//creating an root
        treeroot.left = new TreeNode(2);
        treeroot.left.left = new TreeNode(1);
        treeroot.left.right = new TreeNode(3);
        treeroot.right = new TreeNode(5);
        inorder(treeroot);//function call
        display();//dispplaying
        System.out.println(res);
    }
    
}
