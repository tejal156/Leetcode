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
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true ;
        return ( helperFun(root)[0] == Long.MAX_VALUE )? false : true ; 
    }

    public long[] helperFun(TreeNode root  ) {
    
        if(root == null){ return new long[]{ Long.MIN_VALUE , Long.MAX_VALUE}  ; }
        long lv[] = helperFun(root.left) ;
        long rv[] = helperFun(root.right) ;
        // System.out.println(root.val + " "+lv[0]+" "+lv[1]+" "+rv[0]+" "+rv[1]) ;
        if(  lv[0]>= root.val) return  new long[]{ Long.MAX_VALUE , Long.MIN_VALUE}  ;
        if( rv[1] <= root.val) return  new long[]{ Long.MAX_VALUE , Long.MIN_VALUE}  ;
        return new long[]{ Math.max( rv[0],root.val) ,  Math.min( lv[1] , root.val )  } ;
    }
}