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
        Stack<TreeNode> st = new Stack<>() ;
        List<Integer> ans = new ArrayList<>() ;
        st.push(root) ;
        while( st.size() > 0 ){
            while( st.peek()!= null && st.peek().left != null){
                st.push( st.peek().left) ;
            }
            TreeNode currNode = st.pop() ;
            if(currNode == null && st.size() > 0){
                currNode = st.pop() ;

            }
            if(currNode != null){
                ans.add( currNode.val) ;
                st.push( currNode.right) ; 
            }


        }
        return ans ; 
    }

}