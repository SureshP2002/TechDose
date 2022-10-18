//leetocde-141;
//TC-O(N);


**
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
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;//making a node to point head
        ListNode fast=head;//making a another node to point head
        while(fast!=null&&fast.next!=null)//it will run untill fast and fast.next is null
        {
            slow=slow.next;//moving one step
            fast=fast.next.next;//moving two step
            if(slow==fast)//if two nodes are equal 
            {
                return true;
            }
        
            
        }
        return false;
      
    }
}
