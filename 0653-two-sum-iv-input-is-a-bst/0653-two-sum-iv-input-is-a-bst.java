/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> st1 = new Stack<>() ;
        addAllL( root , st1 ) ;
        Stack<TreeNode> st2 = new Stack<>() ;
        addAllR( root , st2 ) ;
        int l = next(st1) ;
        int r = prev(st2) ;
        while( l < r ){
            // System.out.println(l+" "+r) ;
            if( l+r == k ){
                return true ;
            }
            if(l+r > k ) r = prev(st2);
            else l = next(st1) ;
        }
        return false ;

    }

    public int next(Stack<TreeNode> st){
        TreeNode cn = st.pop() ; 
        int next = cn.val ;
        addAllL(cn.right, st) ;
        return next ;
    }

    public int prev(Stack<TreeNode> st){
        TreeNode cn = st.pop() ; 
        int prev = cn.val ;
        addAllR(cn.left, st) ;
        return prev ;
    }

    public void addAllL(TreeNode root,Stack<TreeNode> st ){
        TreeNode cn = root ;
        while( cn != null ){
            st.push(cn) ;
            cn = cn.left ; 
        }
    }

    public void addAllR(TreeNode root,Stack<TreeNode> st ){
        TreeNode cn = root ;
        while( cn != null ){
            st.push(cn) ;
            cn = cn.right ; 
        }
    }

}