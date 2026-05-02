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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l1CurrentNode = l1;
        ListNode l2CurrentNode = l2;
        ListNode sumHead =null;
        ListNode currentNewNode = null;
        ListNode prevSumHead = null;

        while ( l1CurrentNode != null || l2CurrentNode != null ) {
            int l1Val = l1CurrentNode == null ? 0 : l1CurrentNode.val;
            int l2Val = l2CurrentNode == null ? 0 : l2CurrentNode.val;

            int sum = l1Val + l2Val + carry;
            carry = sum/10;

            currentNewNode = new ListNode ( sum%10 );

            if (prevSumHead == null) sumHead = currentNewNode;
            else prevSumHead.next = currentNewNode;
            prevSumHead = currentNewNode;

            if( l1CurrentNode!=null) l1CurrentNode = l1CurrentNode.next;
            if ( l2CurrentNode!=null) l2CurrentNode = l2CurrentNode.next;


        }
        if(carry!=0) {
            currentNewNode.next = new ListNode (carry);
            currentNewNode = currentNewNode.next;
        }
        currentNewNode.next = null;
        return sumHead;
    }
}
