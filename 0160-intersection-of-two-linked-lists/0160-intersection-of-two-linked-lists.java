/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0 ;
        int l2 = 0 ;

        ListNode temp1 = headA ;
        ListNode temp2 = headB ;

        while( temp1 != null ){
            l1 ++ ;
            temp1 = temp1.next ;
        }
        while( temp2 != null ){
            l2 ++ ;
            temp2 = temp2.next ;
        }

        temp1 = headA ;
        temp2 = headB ;

        if(l2 > l1){
            for(int i = 0 ; i < (l2-l1) ; i++ ){
                temp2 = temp2.next ;
            }
        }
        else if(l1 > l2){
            for(int i = 0 ; i < (l1-l2) ; i++ ){
                temp1 = temp1.next ;
            }
        }

        while(temp1 != null && temp2 != null ){
            if(temp1 == temp2){
                return temp1 ;
            }
            temp2 = temp2.next ;
            temp1 = temp1.next ;
        }

        return null ;

    }
}