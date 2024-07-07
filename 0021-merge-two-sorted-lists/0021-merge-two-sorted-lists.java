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
        ListNode root = new ListNode(-1);
        ListNode ri = root;
        ListNode l1 ,  l2 ;
        l1 = list1 ;
        l2 = list2 ;
        while(l1 != null && l2 != null ){
            if( l1.val < l2.val ){
                ri.next = l1 ;
                ri = ri.next ;
                l1 = l1.next ;
            }
            else{
                ri.next = l2 ;
                ri = ri.next ;
                l2 = l2.next ;                
            }
        }
        if( l1 != null ){
            ri.next = l1 ;
        }
        if( l2 != null ){
            ri.next = l2 ;
        }
        return root.next ;
    }
}