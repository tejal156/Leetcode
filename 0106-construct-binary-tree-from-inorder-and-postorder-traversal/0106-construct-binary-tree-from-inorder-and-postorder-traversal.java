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
        HashMap<Integer , Integer> hm = new HashMap<>() ;
        for(int i = 0 ; i < inorder.length ; i++){
            hm.put( inorder[i] , i) ;
        }
        return helperFun( inorder , postorder , 0 ,inorder.length-1  , 0 , postorder.length-1 , hm) ; 
    }
    public TreeNode helperFun(int[] i , int[] p  , int si , int ei , int sp , int ep , HashMap<Integer , Integer> hm){
        if( si > ei || sp > ep){
            return null ;
        }
        TreeNode root = new TreeNode( p[ep] ) ;
        int iri = hm.get(p[ep]);
        
        int tn = iri -si -1 ; 
        root.left = helperFun( i , p , si , iri-1 , sp , sp+tn , hm  ) ; 
        root.right = helperFun(i , p , iri+1 , ei , sp+tn+1,ep-1 , hm) ; 
        return root ; 
    }
}