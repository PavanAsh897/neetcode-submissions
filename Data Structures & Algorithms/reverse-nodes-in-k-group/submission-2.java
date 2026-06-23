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
        ListNode dummy= new ListNode(0,head);
        ListNode groupPev=dummy;
        while(true){
            ListNode kth= getKth(groupPev,k);
            if(kth==null){
                break;
            }
            ListNode groupNext=kth.next;
            ListNode pev=groupNext;
            ListNode curr= groupPev.next;
            while(curr!=groupNext){
                ListNode temp=curr.next;
                curr.next=pev;
                pev=curr;
                curr=temp;
            }
            ListNode temp=groupPev.next;
            groupPev.next=kth;
            groupPev=temp;
        }
        return dummy.next;
    }
    public ListNode getKth(ListNode l,int k){
        ListNode curr=l;
        while(curr!=null && k>0){
            curr=curr.next;
            k--;
        }
        return curr;

    }
}
