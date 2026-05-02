class LRUCache {
        ListNode head;
        ListNode tail;
        Map<Integer, ListNode> map;
        int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode  resultNode = map.get(key);
        if(resultNode==null) return -1;

        //if result is not null, shift key to the beginning of the list
        delete(resultNode);
        insert(resultNode);
        return resultNode.val;
    }
    
    public void put(int key, int value) {


        ListNode newNode = new ListNode(key, value);
        if(map.containsKey(key)){
            delete(map.get(key));
        }

        map.put (key, newNode);
        insert(newNode);
        // delete(newNode);

        if ( map.size() > capacity){

            map.remove(tail.prev.key);
            delete(tail.prev);

        }



    }

    public void insert (ListNode node){
        node.next= head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void delete (ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public class ListNode {
        ListNode next;
        ListNode prev;
        int key;
        int val;
        public ListNode (){
    
        }

        public ListNode (int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}
