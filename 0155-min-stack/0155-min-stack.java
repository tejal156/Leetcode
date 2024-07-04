class MinStack {
    Stack<Node> st ;
    public MinStack() {
        st = new Stack<>() ;
    }
    
    public void push(int val) {
        if( st.isEmpty() ){
            st.push( new Node (val , val  )    ) ;
        }
        else{
            st.push( new Node (val , Math.min( val , st.peek().minV )  )    ) ;
        }
        
    }
    
    public void pop() {
        st.pop() ;
    }
    
    public int top() {
        return st.peek().val ;
    }
    
    public int getMin() {
        return st.peek().minV ;
    }

    class Node{
        int minV , val ;
        Node( int val , int minV ){
            this.minV = minV ;
            this.val = val ;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */