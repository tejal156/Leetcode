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
        int e = 0 ;
        ListNode ans ;
        ListNode h1 = new ListNode(-1) ;
        ans = h1 ;
        while( l1 != null && l2 != null ){
            int temp = l1.val + l2.val + e  ;
            int cn ;
            if(temp >= 10){
                e = 1  ;
                cn = temp - 10 ;
            }else{
                cn = temp ;
                e =  0;
            }
            h1.next = new ListNode(cn) ;
            h1 = h1.next ;
            l1 = l1.next ;
            l2 = l2.next ;
        }

        while(l1 != null ){
            int temp = l1.val +  e  ;
            int cn ;
            if(temp >= 10){
                e = 1  ;
                cn = temp - 10 ;
            }else{
                cn = temp ;
                e =  0;
            }
            h1.next = new ListNode(cn) ;
            h1 = h1.next ;
            l1 = l1.next ;
        }

        while(l2 != null ){
            int temp = l2.val +  e  ;
            int cn ;
            if(temp >= 10){
                e = 1  ;
                cn = temp - 10 ;
            }else{
                cn = temp ;
                e =  0;
            }
            h1.next = new ListNode(cn) ;
            h1 = h1.next ;
            l2 = l2.next ;
        }

        if(e == 1){
            h1.next = new ListNode(1) ;
            h1 = h1.next ;
        }

        return  ans.next ;

    }

    // public ListNode reverseList(ListNode head) {
    //     ListNode s = null ;
    //     ListNode m = head ;
    //     if( head == null ){
    //         return head ;
    //     }
    //     ListNode e = head.next ;
    //     while(e != null){
    //         m.next = s ;
    //         s= m ; 
    //         m = e ;
    //         e = e.next ;
    //     }
    //     m.next = s ;
    //     return m ;

    // }

}