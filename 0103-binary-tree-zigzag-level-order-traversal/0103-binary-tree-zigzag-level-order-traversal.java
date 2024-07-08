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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  ans = new ArrayList<>() ;
        if(root == null){
            return ans ; 
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root) ;
        q.add(null) ;

        List<Integer> subl = new ArrayList<>() ; 
        boolean ltor = true; 
        while(q.isEmpty() == false ){
            TreeNode cn = q.remove() ;
            if(cn == null && q.size() == 0 ){
                // System.out.println("null  ") ;
                ans.add(subl);
                break ;
            }
            if(cn == null){
                // System.out.print("null  ") ;
                ltor = !ltor ;
                ans.add(subl);
                subl = new ArrayList<>() ; 
                q.add(null) ;
            }
            else{
                // System.out.print(cn.val+" ") ;
                if(ltor == true){
                    subl.add(cn.val) ;
                }else{
                    subl.add(0 , cn.val) ;
                }
                if(cn.left != null){ q.add( cn.left) ;}
                if(cn.right != null){ q.add( cn.right) ;}
            }
        }

        return ans ; 
    }
}