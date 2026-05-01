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

        // Insert each node in a list
        List<ListNode> list  = new ArrayList<>();

        if(head==null || head.next == null) return;

        ListNode currentNode = head;
        while ( currentNode !=null ) {
            list.add(currentNode);
            currentNode = currentNode.next;
        } 

        int low = 0;
        int high = list.size() - 1;
        
        currentNode = head;

        while ( low < high && list.get(low).next !=list.get(high) ) {
            ListNode nextNode = currentNode.next;
            ListNode highNode = list.get(high);
            currentNode.next = highNode;
            list.get(high-1).next = null;
            currentNode.next.next = nextNode;
            high--;
            currentNode = nextNode;
            low++;
        }
        
    }
}
