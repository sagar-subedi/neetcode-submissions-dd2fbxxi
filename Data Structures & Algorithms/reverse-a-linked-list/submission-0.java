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
    public ListNode reverseList(ListNode head) {

        if(head==null) return head;

        ListNode prev = null;
        ListNode currentNode = head;


        do{
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;

        }while(currentNode != null);

        return prev;

        
    }
}
