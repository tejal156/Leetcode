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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode start = head ; 
        ListNode head1 = new ListNode(-1) ;
        ListNode prev =  head1 ; 

        while(true){
            ListNode kthNode = findk(start , k ) ;
            if(kthNode == null ){
                prev.next = start ; 
                return head1.next ; 
            }
            ListNode nextNode = kthNode.next ;
            prev.next =  kthNode ;
            kthNode.next = null ; 
            reverse(start) ;
            prev = start ; 
            start = nextNode ;
        } 
    }

    void reverse(ListNode root){
        ListNode prev = null ;
        ListNode cn = root ;
        
        while(cn != null){
            ListNode next = cn.next ; 
            cn.next = prev ; 
            prev = cn ; 
            cn = next ; 
        }
    }

    ListNode findk( ListNode start ,int k ){
        while(start!= null && k-- >1 ){start = start.next ; }
        return start ; 
    }



}