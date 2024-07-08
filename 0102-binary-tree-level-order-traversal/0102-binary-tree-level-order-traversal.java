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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        if(root == null){
            return ans ;
        }
        Queue<TreeNode> q = new LinkedList<>() ;
        q.add(root);
        q.add(null) ;
        List<Integer>subl  = new ArrayList<>() ;
        while(q.isEmpty() == false ){
            TreeNode cn = q.remove() ;
            
            if(cn == null && q.size() == 0 ){
                ans.add( subl) ;
                break ; 
            }
            if(cn == null){
                ans.add( subl) ;
                subl  = new ArrayList<>();
                q.add(null) ;
            }else{

            
            subl.add( cn.val) ;
            if( cn.left != null ){
                q.add( cn.left ) ;
            }

            if( cn.right != null ){
                q.add( cn.right ) ;
            }
            }

        }

        return ans ; 
    }
}