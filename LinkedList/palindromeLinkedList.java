//leetcode-234;
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
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;//making the reference points to the head
        List<Integer> ans=new ArrayList<>();//creating an array list
        while(curr!=null)
        {
            ans.add(curr.val);//add the elements
            curr=curr.next;//next node
        }
        for(int i=0;i<ans.size()/2;i++)
        {
            if(ans.get(i)!=ans.get(ans.size()-1-i))return false;//checking if both are equal
        }
        return true;
    }
}




