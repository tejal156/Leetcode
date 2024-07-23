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
    public boolean isSymmetric(TreeNode root) {
        if(root == null )return true ; 
        return helperFun(root.left  , root.right  ) ;
    }

    public boolean helperFun(TreeNode rootl ,TreeNode rootr  ){
        if(rootl == null && rootr == null )return true ;
        if(rootl == null || rootr == null )return false ;
        if(rootl.val != rootr.val)return false ; 
        if( !helperFun(rootl.left , rootr.right) )return false  ;
        if( !helperFun(rootl.right , rootr.left ))return false  ;
        return true ; 
    }
}