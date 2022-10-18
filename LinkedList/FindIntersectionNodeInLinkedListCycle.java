//leetcode-142;
//Two pointers
//TC-O(N);

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;//two pointer
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;//moving one step
            fast=fast.next.next;//moving two step
            if(slow==fast)//if there is a loop
            {
              fast=head;//making fast to point head
                while(fast!=slow)//iterate untill fast and slow meets
                {
                    fast=fast.next;//move one step;
                    slow=slow.next;//move one step;
                }
                return fast;
            }
        }
        
        return null;
    }
}
