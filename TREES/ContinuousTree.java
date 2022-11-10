//To check whether the given tree is continues tree or not.
//TC : O(N)

package continuoustree;
import java.util.*;


public class ContinuousTree {
    static class node//node definition
    {
        int data;
        node left,right;
        node(int val)//constructor
        {
            data=val;
            left=right=null;
            
        }
    }
    public static boolean isContinuous(node root)
    {
        if(root==null)return true;//if root is null then there is no value
        if(root.left==null&&root.right==null)return true;//if both left node right node is null then return true(no value
        else if(root.left==null)return Math.abs(root.data-root.right.data)==1&&isContinuous(root.right);//if left node is null then search only for right side
        else if(root.right==null)return Math.abs(root.data-root.left.data)==1&&isContinuous( root.left);//if right node is null then search only for left side
        else return Math.abs(root.data-root.left.data)==1&&Math.abs(root.data-root.right.data)==1&&isContinuous(root.left)&&isContinuous(root.right);//if both node is available then search for oth sides
    }

  
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ContinuousTree tree=new ContinuousTree();//creating an object
        node root=new node(3);//creating an root with val
        root.left = new node(2);//inserting values
        root.right = new node(8);
        root.left.left = new node(1);
        root.left.right = new node(3);
        root.right.right = new node(5);
        System.out.println(isContinuous(root));
        
    }
    
}
