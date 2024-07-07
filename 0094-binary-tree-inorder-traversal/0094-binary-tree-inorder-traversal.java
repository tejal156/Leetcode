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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>() ;
        helperFun(ans , root) ;
        return ans ;
    }
    public void helperFun( List<Integer> ans , TreeNode root){
        if(root == null ){
            return ; 
        }
        helperFun(ans , root.left) ;
        ans.add(root.val) ;
        helperFun( ans , root.right) ;

    }
}