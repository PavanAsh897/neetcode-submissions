/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null)return null;
        Node curr =head;
        while(curr!=null){
            Node copy= new Node(curr.val);
            copy.next =curr.next;
            curr.next= copy;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr= curr.next.next;
        }
        Node cloneHead= head.next;
        curr=head;
        Node cloneNode=cloneHead;
        while(cloneNode!=null){
            curr.next =curr.next.next;
            if(cloneNode.next!=null){cloneNode.next=cloneNode.next.next;

            curr=curr.next;}
            cloneNode=cloneNode.next;
        }
        curr.next=null;
        //cloneNode.next=null;
        return cloneHead;
        
        
    }
}
