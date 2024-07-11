class MedianFinder {
    PriorityQueue<Integer>pq1 ;
    PriorityQueue<Integer>pq2 ;
    public MedianFinder() {
        pq2 = new PriorityQueue<>() ;
        pq1 = new PriorityQueue<>( new Comparator<Integer>(){
            public int compare(Integer n1 , Integer n2 ){
                return n2 - n1 ; 
            }
        }) ;
    }
    
    public void addNum(int num) {
        if(pq1.size() == pq2.size() ){
            pq1.add(num) ;
        }
        else if(pq1.size() > pq2.size() ){
            // if(num >= pq2.peek() ) pq2.add(num) ;
            // else{
            //     pq1.add(num) ;
            //     int temp = pq1.remove() ;
            //     pq2.add(temp) ;
            // }
            pq2.add(num) ;
        }

        if(pq1.size() >0  && pq2.size()>0 && pq2.peek() < pq1.peek() ){
            int temp = pq1.remove() ;
            pq2.add(temp) ;      
            temp = pq2.remove() ;
            pq1.add(temp) ;      
        }

    }
    
    public double findMedian() {
        double ans = 0 ;
        if(pq1.size() == pq2.size() ){
            return (  (double)pq1.peek() + (double)pq2.peek() )/(double)2 ; 
        }
        return (double)pq1.peek() ;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */