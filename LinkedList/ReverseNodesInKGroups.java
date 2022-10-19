//leetcode-25
//TC-O(N);


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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res=new ListNode(-1);//creating dummy node
        res.next=head;//making res to point head
        ListNode ptr=res;
        while(ptr!=null)
        {
            ListNode temp=ptr;//checking for extra nodes at last
            for(int i=0;i<k&&temp!=null;i++)
            {
                temp=temp.next;
            }
            if(temp==null)break;
            ListNode curr=ptr.next,prev=null,next=ptr.next.next;//reversing every k nodes;
            for(int i=0;i<k;i++)
            {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode tail=ptr.next;//making tail to point new node
            tail.next=curr;
            ptr.next=prev;
            ptr=tail;
            
        }
        return res.next;
    }
}
