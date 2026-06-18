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
    public void reorderList(ListNode head) {
        ListNode slow= head;
        ListNode fast= head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        ListNode pev=null;
        slow.next=null;
        while(second!=null){
            ListNode t= second.next;
            second.next=pev;
            pev= second;
            second=t;
        }
        second= pev;
        ListNode first=head;
        while(second!=null){
            ListNode tem1=first.next;
            ListNode tem2 = second.next;
            first.next=second;
            second.next=tem1;
            first=tem1;
            second=tem2;
        }

        
    }
}
