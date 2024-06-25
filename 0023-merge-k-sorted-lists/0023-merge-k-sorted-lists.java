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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if( lists.length == 1 )
        {
            return lists[0] ;
        }

        if( lists.length == 0 )
        {
            return null ;
        }

        ListNode left = mergeKLists(  Arrays.copyOfRange( lists , 0 , (lists.length/2)   ) ) ;
        ListNode right = mergeKLists(  Arrays.copyOfRange( lists ,  (lists.length/2)  , lists.length )) ;

        // return merge( left , right ) ;
        ListNode temp = new ListNode(-1);
        ListNode head = temp ;

        while( left != null && right != null )
        {
            // number with small value add first
            if( left. val <= right . val )
            {
                temp.next = left ;
                temp = temp . next ;
                left = left . next ;
            }
            else
            {
                temp.next = right ;
                temp = temp . next ;
                right = right . next ;                
            }
        }

        while( left != null )
        {
            temp.next = left ;
            temp = temp . next ;
            left = left . next ;
        }
        while( right != null )
        {
            temp.next = right ;
            temp = temp . next ;
            right = right . next ;
        }

        return head . next ;
        

    }

    // public ListNode merge(ListNode left , ListNode  right )
    // {
    //     ListNode temp = new ListNode(-1);
    //     ListNode head = temp ;

    //     while( left != null && right != null )
    //     {
    //         // number with small value add first
    //         if( left. val <= right . val )
    //         {
    //             temp.next = left ;
    //             temp = temp . next ;
    //             left = left . next ;
    //         }
    //         else
    //         {
    //             temp.next = right ;
    //             temp = temp . next ;
    //             right = right . next ;                
    //         }
    //     }

    //     while( left != null )
    //     {
    //         temp.next = left ;
    //         temp = temp . next ;
    //         left = left . next ;
    //     }
    //     while( right != null )
    //     {
    //         temp.next = right ;
    //         temp = temp . next ;
    //         right = right . next ;
    //     }

    //     return head . next ;
        
    // }
}