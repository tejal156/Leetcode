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
    public int kthSmallest(TreeNode root, int k) {
        int counter[] = new int[1] ;
        int ans[] = new int[1] ;
        helperFun(root , k , ans , counter);
        return ans[0] ;
    }
    public boolean helperFun( TreeNode root, int k , int ans[] , int counter[]){
        if(root == null) return true ;

        if(helperFun(root.left , k , ans , counter) == false)return false ;
        counter[0]++ ;
        if( counter[0] == k){ans[0] = root.val ; return false; }
        if(helperFun(root.right , k , ans , counter) == false)return false ;
        return true ; 
    }
}