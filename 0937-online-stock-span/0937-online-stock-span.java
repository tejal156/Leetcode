class StockSpanner {
    int index ;
    Stack<Pair> st ;
    public StockSpanner() {
        st = new Stack<>() ;
        index = 0 ;
    }
    
    public int next(int price) {


        while(st.isEmpty() == false && st.peek().val <= price ){
            st.pop() ;
        }


        if(st.isEmpty() ){  
            st.push( new Pair( price , index ) ) ;
            index ++ ;
            return index ;
        }
        Pair tempPeek = st.peek() ;
        st.push( new Pair( price , index ) ) ;
        index ++ ;
        return index - tempPeek.index-1 ;


    }

    class Pair{
        int val , index ;
        Pair( int val , int index ){
            this.val = val ;
            this.index = index; 
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */