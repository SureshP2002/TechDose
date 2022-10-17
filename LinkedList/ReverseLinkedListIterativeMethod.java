//leetcode-206
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
       if(head==null||head.next==null)return head;//if no nodes then return 
        ListNode prev=null;//making prev to point null;
        ListNode curr=head;//making curr to point head;
        ListNode next=head.next;//making next to point head.next;
        while(curr!=null)
        {
            next=curr.next;//storing curr.next to next;
            curr.next=prev;//putting prev addres to curr.next;
            prev=curr;//making prev to point curr;
            curr=next;//making curr to point next;
            
        }
        head=prev;//making head to point prev
        return head;
    }
}
