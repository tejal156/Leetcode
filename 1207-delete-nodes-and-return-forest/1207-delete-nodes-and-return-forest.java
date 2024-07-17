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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>() ;
        ans.add(root);
        for(int i = 0 ; i < to_delete.length ; i++){
            findInAll(ans,to_delete[i]) ;
        }
        return ans ; 
    }
    

    public void findInAll(List<TreeNode> ans ,int target ){
        for(TreeNode tn : ans){
            if(findNDelete(tn,null,target,ans))break ;
        }
    }

    public boolean findNDelete(TreeNode curr , TreeNode prev , int target,List<TreeNode> ans){
        if(curr == null )return false ; 
        if(curr.val == target){
            if(prev!= null && prev.right==curr)prev.right = null ;
            else if(prev!= null && prev.left ==curr)prev.left = null ;
            if(ans.contains(curr)){
                ans.remove(curr) ;
            }
            if(curr.left!=null)ans.add(curr.left);
            if(curr.right!=null)ans.add(curr.right);
            return true ; 
        }

        if(findNDelete(curr.left , curr, target, ans) )return true ;
        if(findNDelete(curr.right , curr, target, ans) )return true ;
        return false ; 
    }

}