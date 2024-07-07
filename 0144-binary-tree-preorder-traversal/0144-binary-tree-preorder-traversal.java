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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root == null ){
            return ans ; 
        }
        Stack<TreeNode> st = new Stack<>() ;
        ans.add(root.val) ;
        st.push(root) ;
        while(st.size() > 0){
            while(st.size() > 0 && st.peek() != null && st.peek().left!= null ){
                ans.add( st.peek().left.val  ) ;
                st.push( st.peek().left) ;
            }
            if(st.peek() == null ){
                st.pop() ; 
            }
            if(st.size() > 0){
                TreeNode tempN = st.pop() ;
                if( tempN.right != null) ans.add( tempN.right.val  ) ;
                
                st.push( tempN.right ) ;
            }
        }
        return ans ; 

    }
}