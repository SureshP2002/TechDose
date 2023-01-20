//code for reducing the size of msg bit by encoding to reduce the cost


package huffmancoding;
import java.util.*;


public class HuffmanCoding {
   static class Node{
       char c;//for character
       Node left;//left node
       Node right;//right node
       int data;//char count
       Node(char c,Node left,Node right,int data)//constructor
       {
           this.c=c;
           this.left=left;
           this.right=right;
           this.data=data;
       }
   }
   public static void findcode(Node root,List<String> l,String ans)
   {
       if(root==null)return;//if root null means return because end
       if(root.left==null&&root.right==null)//if root's left and root's right is null add to list
       {
           l.add(ans);
           return;
       }
       findcode(root.left,l,ans+"0");//preorder add 0 to left side
       findcode(root.right,l,ans+"1");//preorder add 1 to right side
   }
    public static List<String> Huffmancode(String s,int len,int freq[])
    {
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.data-b.data);//sorting based on minimum char count(freq)
        for(int i=0;i<len;i++)
        {
            pq.add(new Node(s.charAt(i),null,null,freq[i]));//adding to queue
        }
        while(pq.size()>1)
        {
            Node a=pq.poll();//taking two lowest and add them and put into pq as new node
            Node b=pq.poll();
            int newData=a.data+b.data;
            pq.add(new Node('-',a,b,newData));
        }
        Node root=pq.poll();//lastly root will remain there
        List<String> ans=new ArrayList<>();
        findcode(root,ans,"");//finding code for message bit
        
        return ans;
    }
    public static void main(String[] args) {
        String s="ABCD";//character message
        int freq[]={50,40,5,5};//no of times that charcter in the message
        System.out.print(Huffmancode(s,s.length(),freq));
    }
    
}
