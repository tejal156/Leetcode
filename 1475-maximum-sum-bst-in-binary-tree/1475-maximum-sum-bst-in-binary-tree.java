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
    int ans =  0 ;
    public int maxSumBST(TreeNode root) {
        if(root.left == null && root.right == null) return root.val ;
        helperFun(root) ;
        return  ans ;        
    }
    public int[] helperFun(TreeNode root  ) {
    
        if(root == null){ return new int[]{ Integer.MAX_VALUE , Integer.MIN_VALUE, 0}  ; }
        int lv[] = helperFun(root.left) ;
        int rv[] = helperFun(root.right) ;
        // System.out.println(root.val + " "+lv[0]+" "+lv[1]+" "+rv[0]+" "+rv[1]) ;
        if(  lv[1]>= root.val) return  new int[]{ Integer.MIN_VALUE , Integer.MAX_VALUE,Math.max(rv[2], lv[2]) }  ;
        if( rv[0] <= root.val) return  new int[]{ Integer.MIN_VALUE , Integer.MAX_VALUE,Math.max(rv[2], lv[2]) }  ;
        ans = Math.max(ans ,lv[2]+rv[2]+root.val ) ;
        return new int[]{ Math.min( lv[0],root.val) ,  Math.max( rv[1] , root.val ),lv[2]+rv[2]+root.val  } ;
    }
}
