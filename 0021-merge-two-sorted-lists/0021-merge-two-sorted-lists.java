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
        ListNode l1 = list1 ;
        ListNode l2 = list2 ;
        ListNode ans  ;
        ListNode h1  = new ListNode(-1);
        ans = h1 ;
        while( l1 != null && l2 != null ){
            if( l1.val >= l2.val){
                h1.next = l2 ;
                l2 = l2.next ;
                h1 = h1.next ;
            }else{
                h1.next = l1 ;
                l1 = l1.next ;
                h1 = h1.next ;               
            }

        }

        if(l1 != null){
                h1.next = l1 ;

        }

        if(l2 != null){
                h1.next = l2 ;

        }

        return ans.next ;
    }
}