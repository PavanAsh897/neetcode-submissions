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
       Node curr=head;
       while(curr!=null){
        Node copy=new Node(curr.val);
        Node temp=curr.next;
        curr.next=copy;
        copy.next=temp;
        curr=temp;
       }
       curr=head;
       while(curr!=null){
        Node temp =curr.next.next;
        if(curr.random!=null){
            curr.next.random=curr.random.next;
        }
        curr=temp;
       }
       Node newnode=new Node(0);
       Node copytail=newnode;
       curr= head;
       while(curr!=null){
        Node copy=curr.next;
        curr.next=copy.next;
        copytail.next=copy;
        copytail=copytail.next;
        curr=curr.next;
        
       }
       return newnode.next;
    }
}
