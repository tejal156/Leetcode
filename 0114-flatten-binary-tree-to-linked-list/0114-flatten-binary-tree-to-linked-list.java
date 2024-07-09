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
    public void flatten(TreeNode root) {
        makeLinks(root) ;
        breakLinks(root) ;
    }

    public void makeLinks(TreeNode root){
        TreeNode cn = root ;
        if(cn == null ){
            return ;
        }
        // if r exist then enstablish a link 
        if( cn.right != null ){
            TreeNode rn = cn.right ;
            if(cn.left!= null ){
                cn = cn.left ;
                while(cn.right != null || cn.left != null ){
                    while(cn.right != null ){
                        cn = cn.right ;
                    }
                    if(cn.left != null ){
                        cn = cn.left ;
                    }
                }
                cn.right = rn ; 
                // System.out.println("link between : "+ cn.val + " "+rn.val) ;
            }
        }
        cn = root ;
        if(cn.left != null ){
            makeLinks( cn.left) ;
        }
        else{
            makeLinks( cn.right) ;  
        }

    }

    public void breakLinks(TreeNode root){
        if(root == null ){
            return ; 
        }
        if(root.left == null ){
            breakLinks( root.right) ;
        }
        else{
            // System.out.println("link break : "+ root.val + " "+root.right.val) ;
            root.right = root.left ;
            root.left = null ;
            breakLinks( root.right) ;
        }
    }
}