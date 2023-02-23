//leetcode-83
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;//making curr to point to the head
        if(head==null)return null;//if head is null then there is no node;
        if(head.next==null)return head;//if head.next is null then theree is only one node;
        while(curr.next!=null)//iterating untill curr.next is not null
        {
            if(curr.val==curr.next.val)//both curr val and currs next value is same
            {
                curr.next=curr.next.next;//skip the next node;
            }
            else
            {
                curr=curr.next;//move one step;
            }
        }
        return head;
    }
}
