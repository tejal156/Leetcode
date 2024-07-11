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
    public void flatten(TreeNode root) {
        if(root == null ){
            return ; 
        }
        TreeNode cn = root ; 
        if(cn.left != null && cn.right!= null ){
            cn = cn.left ;
            while(  cn.right != null ){
                cn = cn.right ; 
            }
            cn.right = root.right ; 
        }
        if(root.left == null) flatten( root.right ) ;
        else{ 
            root.right = root.left ;
            root.left = null ;
            flatten( root.right ); 
        }

    }


}