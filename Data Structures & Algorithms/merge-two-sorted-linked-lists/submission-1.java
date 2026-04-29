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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if( list1 == null && list2 == null) return null;
        if (list1==null) return list2;
        if (list2==null) return list1;
        

        ListNode list1CurrentNode = list1;
        ListNode list2CurrentNode = list2;

        ListNode newHead;
        ListNode currentNodeForResult;

        if (  list2 == null ||list1.val < list2.val){
            newHead = new ListNode(list1.val);
            list1CurrentNode = list1.next;
        }else {
            newHead = new ListNode(list2.val);
            list2CurrentNode = list2.next;
        }
        currentNodeForResult = newHead;

        while ( list1CurrentNode != null || list2CurrentNode != null ) {

            if(list1CurrentNode == null || (list2CurrentNode!=null && list2CurrentNode.val < list1CurrentNode.val)){
                currentNodeForResult.next = new ListNode(list2CurrentNode.val);
                currentNodeForResult = currentNodeForResult.next;
                list2CurrentNode = list2CurrentNode.next;
            }  else  if ( list2CurrentNode == null || ( list1CurrentNode!=null && list1CurrentNode.val <= list2CurrentNode.val)) {
                currentNodeForResult.next = new ListNode(list1CurrentNode.val);
                                currentNodeForResult = currentNodeForResult.next;

                list1CurrentNode = list1CurrentNode.next;
            }

        }

        currentNodeForResult.next = null;
        return newHead;

    }
}