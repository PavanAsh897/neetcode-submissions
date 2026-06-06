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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy= new ListNode(-1,head);
        ListNode groupPev=dummy;
        while(true){
            ListNode kth= getKth(groupPev,k);
            if(kth==null) break;
            ListNode groupNext=kth.next;
            ListNode pev=kth.next,curr=groupPev.next;
            while(curr!=groupNext){
                ListNode tmp= curr.next;
                curr.next=pev;
                pev= curr;
                curr= tmp;
            }
            ListNode temp=groupPev.next;
            groupPev.next=pev;
            groupPev=temp;
        }

      return dummy.next;
        
    }
    public ListNode getKth(ListNode node, int k){
        ListNode curr =node;
        while(curr!=null && k>0){
            curr= curr.next;
            k--;
        }
        return curr;
    }
}
