//leetcode-2
//TC-O(N)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        ListNode Dummy=new ListNode(-1);//creating some dummy node
        ListNode temp=Dummy;//creating refernce to node
        int carry=0;
        while(l1!=null||l2!=null||carry!=0)
        {
            int sum=0;
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;//adding sum
            carry=sum/10;//if there is carry
            ListNode node=new ListNode(sum%10);//creating node and adding the sum
            temp.next=node;
            temp=temp.next;
        }
        return Dummy.next;
        
        
        
        
    }
}
