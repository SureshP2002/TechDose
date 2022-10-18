//leetocde-206
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
    public ListNode reverseList(ListNode head) {
      if(head==null||head.next==null)return head;//returning if head.next is null(lastNode)
        ListNode ans=reverseList(head.next);//recursive call
        head.next.next=head;//making last node link to before node
        head.next=null;//making curr node next to null;
        return ans;//return the ans
    }
}


