//leetcode-21
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);//creating an dummy node
        ListNode curr=temp;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)//if list1 value is less than list2 val
            {
                curr.next=l1;//putting address of the l1 node to currr next
               l1=l1.next;//moving l1 node to next
            }
            else
            {
                curr.next=l2;//putting address of the l2 node to cuurr next
                l2=l2.next;//moving l2 to next
            }
            curr=curr.next;
            
        }
        if(l1!=null)
        {
            curr.next=l1;
        }
        if(l2!=null)
        {
            curr.next=l2;
        }
        return temp.next;
        
    }
}
