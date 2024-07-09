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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helperFun( inorder , postorder , 0 ,inorder.length-1  , 0 , postorder.length-1) ; 
    }
    public TreeNode helperFun(int[] i , int[] p  , int si , int ei , int sp , int ep){
        if( si > ei || sp > ep){
            return null ;
        }
        TreeNode root = new TreeNode( p[ep] ) ;
        int iri = 0 ;
        for(int n = si ; n <= ei ; n++){
            if( i[n] == p[ep]){
                iri = n ;
                break ;
            }
        }
        System.out.println(root.val +" "+iri) ;
        int tn = iri -si -1 ; 
        root.left = helperFun( i , p , si , iri-1 , sp , sp+tn ) ; 
        root.right = helperFun(i , p , iri+1 , ei , sp+tn+1,ep-1) ; 
        return root ; 
    }
}