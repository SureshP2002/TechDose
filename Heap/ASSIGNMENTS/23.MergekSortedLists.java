//leetcode -23
//approach-priorityQueue
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();//creating an priority queue (MinHeap)
        for(ListNode a:lists)
        {
            while(a!=null)
            {
                pq.add(a.val);//adding them into the queue
                a=a.next;
            }
        }
        ListNode head=null;
        if(pq.size()==0)//if no element
        {
            return null;
        }
        else
        {
        head=new ListNode(pq.poll());//creating node for adding element
        ListNode temp=head;//creating refernce node
        while(pq.size()!=0)
        {
            temp.next=new ListNode(pq.poll());//linked next node
            temp=temp.next;
            
        }
        }
        return head;
        
        
    }
}
