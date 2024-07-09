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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperFun( nums , 0 , nums.length-1  ) ;
    }
    public TreeNode helperFun(int[] nums , int si , int ei ){
        if(ei < si ){
            return null ;
        }
        int mid = si+(ei-si)/2 ;
        TreeNode root = new TreeNode( nums[mid] ) ;

        root.left = helperFun(nums , si , mid-1) ;
        root.right = helperFun(nums , mid+1 ,ei) ;

        return root ;
    }
}