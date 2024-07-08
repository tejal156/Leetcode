/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null || root == p || root == q){
            return root ;
        }
        TreeNode lr = lowestCommonAncestor( root.left , p , q) ;
        TreeNode rr = lowestCommonAncestor( root.right , p , q) ;
        if(lr != null && rr != null){
            return root ; 
        }
        if(lr == null && rr == null){
            return null ;
        }
        return (lr != null)? lr : rr ;
    }
}