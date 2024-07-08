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
    public boolean isBalanced(TreeNode root) {
        return (helperFun(root)== -1) ? false : true ; 
    }

    public int helperFun(TreeNode root){
        if(root == null ){
            return 0 ;
        }
        int lh = helperFun(root.left ) ;
        int rh = helperFun(root.right ) ;
        if(lh == -1 || rh == -1){
            return -1 ; 
        }
        if( Math.abs(lh-rh) <= 1 ){
            return Math.max(lh,rh)+1 ;
        }
        else{
            return -1 ;
        }
    }
}