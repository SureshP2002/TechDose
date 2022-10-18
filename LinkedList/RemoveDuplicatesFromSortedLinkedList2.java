//leetcode-82;
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res=new ListNode(0,head);//creating a dummy node and point to head
        ListNode temp=res;//making temp to pint res
        while(head!=null)
        {
            if(head.next!=null&&head.val==head.next.val)//if duplicates
            {
                while(head.next!=null&&head.val==head.next.val)//skiping duplicates
                {
                    head=head.next;
                }
                temp.next=head.next;//making temp to point next non duplicate node
            }
            else//no duplicates
            {
              temp=temp.next;
            }
            head=head.next;//moving head
        }
        return res.next;
        
    }
}
