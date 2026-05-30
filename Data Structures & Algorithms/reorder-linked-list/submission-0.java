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
        List<ListNode> node = new ArrayList<>();
        ListNode temp= head;
        while(temp!=null){
            node.add(temp);
            temp=temp.next;
        }
        int l=0,r=node.size()-1;
        while(l<r){
            node.get(l).next=node.get(r);
            l++;
            if(l>r){
                break;
            }
            node.get(r).next=node.get(l);
            r--;
        }
        node.get(l).next =null;
        
    }
}
