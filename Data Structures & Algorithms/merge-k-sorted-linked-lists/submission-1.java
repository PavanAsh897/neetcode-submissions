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
        // if(lists.length==0) return null;
        // for(int i=1; i<lists.length;i++){
        //     lists[i]=mergeList(lists[i],lists[i-1]);
        // }
        // return lists[lists.length-1];
        if(lists==null|| lists.length==0) return null;
        while(lists.length>1){
            ListNode [] merged= new ListNode[(lists.length+1)/2];
            int index=0;
            for(int i=0; i<lists.length;i=i+2){
                ListNode l1=lists[i];
                ListNode l2= (i+1)<lists.length? lists[i+1]:null;
                merged[index++]= mergeList(l1,l2);
            }
            lists=merged;
        }
        return lists[0];

       

        


    }
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy= new ListNode(-1);
        ListNode tail=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1!=null){
            tail.next=l1;

        }
        if(l2!=null){
            tail.next=l2;
        }
        return dummy.next;
    }
}
