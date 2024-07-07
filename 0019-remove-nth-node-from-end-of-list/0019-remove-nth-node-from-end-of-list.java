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
        ListNode cn = head ; 
        int ci = 0 ;
        while( cn != null ){
            cn = cn.next ;
            ci++ ;
        }
        int size = ci ;
        int index = ci - n - 1;
        if(index == -1){
            head = head.next ;
            return head ;
        }


        cn = head ; 
        ci = 0 ;
        while(  ci !=index ){
            cn = cn.next ;
            ci++ ;
        }
        if(n == 1){
            cn.next = null ;
            return head ;
        }
        cn.next = cn.next.next ;
        return head ;

    }
}