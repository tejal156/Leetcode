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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>() ;
        int max = 0 ;
        q.add( new Pair(root , 0) ) ;
        while( q.size() > 0 ){
            int size = q.size() ;
            int mi = q.peek().p ; 
            int f =0, l=0 ; 
            for(int i =1 ; i <= size ; i++ ){
                Pair cn = q.remove() ;
                int cp = cn.p ;
                if(i == 1)f= cp ;
                if(i == size)l= cp ;
                if(cn.n.left != null ) q.add( new Pair(cn.n.left , (cp-mi)*2+1 ) ) ;
                if(cn.n.right != null ) q.add( new Pair(cn.n.right , (cp-mi)*2+2 ) ) ;
            }
            max = Math.max( max , l-f+1) ;

        }
        return max ; 

    }

    class Pair{
        TreeNode n ;
        int p ;
        Pair( TreeNode n , int p ){
            this.n = n ;
            this.p = p ;
        }
    }
}