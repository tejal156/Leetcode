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
class BSTIterator {
    Stack<TreeNode> st ; 
    public BSTIterator(TreeNode root) {
        st = new Stack<>() ;
        TreeNode cn = root ;

        while( cn != null ){
            st.push(cn) ;
            cn = cn.left ; 
        }
    }
    
    public int next() {
        TreeNode cn = st.pop() ; 
        int next = cn.val ;
        if(cn.right != null ){
            cn = cn.right ; 
            while(  cn != null ){
                st.add(cn) ;
                cn = cn.left ;
            }
        }
        return next ;
    }
    
    public boolean hasNext() {
        return (st.size() == 0)? false : true ;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */