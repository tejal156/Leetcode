/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return node ; 
        HashMap<Integer , Node> hm = new HashMap<>();
        return helperFun( node , hm) ;
    }

    public Node helperFun(Node node , HashMap<Integer , Node> hm ){
        if(hm.containsKey(node.val) == true )return hm.get(node.val) ;

        Node cn  = new Node(node.val) ;
        hm.put(cn.val , cn) ;
        for(int i = 0 ; i < node.neighbors.size() ; i++){
            cn.neighbors.add( helperFun( node.neighbors.get(i) ,hm)  ) ;
        }
        return cn ; 

    }
}