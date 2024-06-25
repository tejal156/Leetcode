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
        ListNode prev = null ;
        
        ListNode start = head ;
        ListNode nextE = null ;

        while(true){
            ListNode end = findK( start , k) ;
            if(end == null){
                prev.next  = start ;
                return head ;
            }
            else if(start == head ){
                nextE = end.next ;
                end.next = null ;
                head = end ;
                reverse( start) ;
                prev = start ;
                start = nextE ; 
                

            }
            else{
                nextE = end.next ;
                end.next = null ;
                prev.next = end ;
                reverse( start) ;
                prev = start ;
                start = nextE ;

            }
        }
        
    }

    public ListNode findK( ListNode n , int k ){
        for(int i = 0 ; i < k-1 ; i++ ){
            if( n == null ){
                return null ;
            }
            n = n.next ;
        }
        return n ;
    }

    public void reverse(ListNode n){
        if(n == null || n.next == null){
            return  ;
        }
        ListNode s = null ;
        ListNode m = n ;
        ListNode e = n.next ;
        while( m != null){
            m.next = s ;
            s = m ;
            m = e ;
            if(e != null){
                e= e.next ;
            }    
        }

    }

}