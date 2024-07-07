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
        TreeNode currn = root ; 
        while(currn != null ){
            if(currn.left == null){
                ans.add( currn.val) ;
                currn = currn.right ;
            }
            else{
                TreeNode prev = currn.left ;
                while(prev.right != null && prev.right != currn){
                    prev = prev.right ;
                }
                if(prev.right == null){
                    prev.right = currn ;
                    currn = currn.left ;
                }
                else if( prev.right == currn ){
                    prev.right = null ;
                    ans.add(currn.val) ;
                    currn = currn.right ;
                }
            }
        }

    return ans ; 

    }
}