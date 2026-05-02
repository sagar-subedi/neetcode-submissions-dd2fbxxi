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

        if ( head == null) return head;

        Map<Node, Node> map = new HashMap<>();
        // Map<Integer, Node> map2 = new HashMap<>();


        // int index = 0;
        Node currentNode = head;
        Node prev = null;

        while ( currentNode != null ) {
            Node copyNode = new Node(currentNode.val);
            map.put ( currentNode, copyNode);
            // // map2.put (copyNode, index );

            if ( prev != null ) prev.next = copyNode;
            prev = copyNode;
            currentNode = currentNode.next;

        }

        currentNode = head;

        // index = 0;
        while ( currentNode != null ) {
            map.get(currentNode).random = map.get(currentNode.random);
            currentNode = currentNode.next;
        }

        return map.get(head);
    }
}
