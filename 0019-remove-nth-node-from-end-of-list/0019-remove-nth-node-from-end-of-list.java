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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0 ;
        ListNode temp = head ;
        while(temp != null){
            temp = temp.next ;
            l++ ;
        }
        int i = l - n ;
        if( i == 0){
            head = head.next ;
            return head ;
        }
        temp = head ;
        for(int i1 = 0 ; i1 < i-1 ; i1 ++){
            temp = temp.next ;
        }
        temp.next = temp.next.next ;
        return head ;
    }
}