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
        // List<ListNode> node = new ArrayList<>();
        // ListNode temp= head;
        // while(temp!=null){
        //     node.add(temp);
        //     temp=temp.next;
        // }
        // int l=0,r=node.size()-1;
        // while(l<r){
        //     node.get(l).next=node.get(r);
        //     l++;
        //     if(l>=r){
        //         break;
        //     }
        //     node.get(r).next=node.get(l);
        //     r--;
        // }
        // node.get(l).next =null;
        ListNode slow=head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;
        }
        ListNode second =slow.next;
        ListNode pev=null;
        slow.next=null;
        while(second!=null){
            ListNode tem= second.next;
            second.next=pev;
            pev=second;
            second= tem;


        }
        ListNode first=head;
        second= pev;
        
        while(second!=null){
            ListNode temp1=first.next,temp2=second.next;
            second.next=first.next;
            first.next= second;
            first=temp1;
            second=temp2;

        }
        
    }
}
