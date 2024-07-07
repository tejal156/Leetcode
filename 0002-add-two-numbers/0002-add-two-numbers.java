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
        ListNode l1i = l1 ;
        ListNode l2i = l2 ;
        ListNode ans = new ListNode(-1) ;
        ListNode ansi = ans ;
        int c = 0 ;
        int cn = 0 ;
        
        while( l1i != null && l2i != null){
            int an = l1i.val + l2i.val + c ;
            if(an >= 10 ){
                cn = an -10 ;
                c = 1  ;
            }
            else{
                cn = an ;
                c = 0 ;
            }
            l1i = l1i.next ;
            l2i = l2i.next ;
            ansi.next = new ListNode(cn) ;
            ansi = ansi.next ; 
        }

        while( l1i != null ){
            int an = l1i.val  + c ;
            if(an >= 10 ){
                cn = an -10 ;
                c = 1  ;
            }
            else{
                cn = an ;
                c = 0 ;
            }
            l1i = l1i.next ;
            ansi.next = new ListNode(cn) ;
            ansi = ansi.next ;
        }       
        while( l2i != null ){
            int an = l2i.val  + c ;
            if(an >= 10 ){
                cn = an -10 ;
                c = 1  ;
            }
            else{
                cn = an ;
                c = 0 ;
            }
            l2i = l2i.next ;
            ansi.next = new ListNode(cn) ;
            ansi = ansi.next ;
        }  
        if(c == 1){
            ansi.next = new ListNode(1) ;
            ansi = ansi.next ;
        }   
        return ans.next ;
    }
}