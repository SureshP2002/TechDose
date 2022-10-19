//leetcode-148
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow=head;//slow pointer
        ListNode fast=head;//fast pointer
        ListNode prev=null;
        while(fast!=null&&fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
         }
        prev.next=null;
        //spliting halfs;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return MergeSort(l1,l2);//merging them;
    }
    ListNode MergeSort(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(0);//creating dummy node
        ListNode ans=dummy;//ans pointer to dummy node
        while(l1!=null&l2!=null)
        {
            if(l1.val<l2.val)//if l1 is lesser
            {
                ans.next=l1;
                l1=l1.next;
            }
            else//if l2 is lesser
            {
                ans.next=l2;
                l2=l2.next;
            }
            ans=ans.next;
            
        }
        if(l1!=null)//for remaining elements
        {
            ans.next=l1;
        }
        if(l2!=null)/for remaining elements
        {
            ans.next=l2;
        }
        return dummy.next;
    }
}
