class Node{
    int key;
    int val;
    Node pev;
    Node next;
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.pev=null;
        this.next=null;
    }
}
class LRUCache {
    Map<Integer,Node>cache;
    int cap;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        cache=new HashMap<>();
        cap=capacity;
        left=new Node(0,0);
        right = new Node(0,0);
        left.next=right;
        right.pev=left;
        
    }
    public void remove(Node node){
        Node pev= node.pev;
        Node next= node.next;
        pev.next =next;
        next.pev=pev;

    }
    public void insert(Node node){
        Node pev= right.pev;
        pev.next=node;
        node.pev=pev;
        node.next=right;
        right.pev=node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node =cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);
        if(cache.size()>cap){
            Node lru= left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}
