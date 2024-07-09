/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null ) return root ;

        Queue<Node> q = new LinkedList<>() ;
        q.add(root) ;
        q.add(null) ;

        Node prev = null ;

        while( true ){
            Node cn = q.remove() ;
            if(prev != null ){
                prev.next = cn ; 
            }
            prev = cn ;

            if(cn == null && q.size() == 0){
                break;
            }
            if(cn == null ){
                q.add(cn) ;
            }
            else{
                if(cn.left != null )q.add( cn.left ) ;
                if(cn.right != null )q.add( cn.right ) ;
            }
        }  
        return root ;
    }
}