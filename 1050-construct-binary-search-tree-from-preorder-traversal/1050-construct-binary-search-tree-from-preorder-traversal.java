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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helperFun( preorder , 0 , preorder.length-1 ) ;
    }
    public TreeNode helperFun(int[] preorder , int si , int ei){
        if( ei < si ){
            return null ;
        }
        int gi = ei+1 ;
        for(int i = si+1 ; i <= ei ; i++){
            if( preorder[si] < preorder[i]){
                gi = i ;
                break ; 
            }
        }
        TreeNode root = new TreeNode( preorder[si]) ;
        root.left = helperFun( preorder,si+1, gi-1) ;
        root.right = helperFun( preorder,gi, ei) ;
        return root ;
    }
}