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
    public int diameterOfBinaryTree(TreeNode root) {
        return helperFun(root)[1] ;
    }

    public int[] helperFun(TreeNode root){
        if(root == null ){
            int temp[] = {0 , 0} ;
            return temp ;
        }

        int ls[] = helperFun(root.left) ;
        int rs[] = helperFun(root.right) ;
        
        int cans[] = { 1 + Math.max( ls[0] , rs[0]) ,  Math.max(  ls[0] + rs[0]  , Math.max(ls[1] , rs[1]  )  )  } ;
        return cans ; 

    } ;
}