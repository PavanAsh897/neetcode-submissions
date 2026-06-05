class Node{
    int key;
    int val;
    Node pev;
    Node next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
        this.pev=null;
        this.next=null;
    }


}
class LRUCache {
    int cap;
    Map<Integer, Node> cach;
    Node left;
    Node right;


    public LRUCache(int capacity) {
        this.cap =capacity;
        this.cach=new HashMap<>();
        this.left =new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.pev=this.left;

        
    }
    private void remove(Node node){
        Node pev= node.pev;
        Node next=node.next;
        pev.next=next;
        next.pev=pev;
    }
    private void insert(Node node){
        Node pev = this.right.pev;
        pev.next=node;
        node.pev=pev;
        node.next=this.right;
        this.right.pev=node;
    }
    
    public int get(int key) {
        if(this.cach.containsKey(key)){
            Node node=this.cach.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(this.cach.containsKey(key)){
            remove(this.cach.get(key));
        }
        Node newNode= new Node(key,value);
        cach.put(key,newNode);
        insert(newNode);
        if(cach.size()>this.cap){
            Node lru=this.left.next;
            remove(lru);
            cach.remove(lru.key);
        }
        
    }
}
