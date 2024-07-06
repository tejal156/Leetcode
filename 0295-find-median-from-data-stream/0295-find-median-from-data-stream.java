class MedianFinder {
    PriorityQueue<Integer> pq1 ;
    PriorityQueue<Integer> pq2 ;

    public MedianFinder() {
        pq1 =  new PriorityQueue<>( new Comparator<Integer>(){
            public int compare( Integer n1 , Integer n2 ){
                return n2 - n1;
            }
        }) ; 
        pq2 = new PriorityQueue<>( new Comparator<Integer>(){
            public int compare( Integer n1 , Integer n2 ){
                return n1 - n2;
            }
        }) ; 
    }
    
    public void addNum(int num) {
        pq1.add(num) ;
        if(pq1.size() > pq2.size()+1 ){
            pq2.add( pq1.remove() ) ;
        }

        if( !pq1.isEmpty() &&  !pq2.isEmpty() && pq1.peek() > pq2.peek() ){
            pq2.add( pq1.remove() ) ;
            pq1.add( pq2.remove() ) ;
        }
    }
    
    public double findMedian() {
        double ans ;
        if(pq1.size() == pq2.size()){
            ans = (double)pq1.peek() + (double)pq2.peek() ;
            ans = ans/(double)2 ;
        }
        else{
            ans = (double)pq1.peek() ;
        }
        return ans ; 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */