class LFUCache {
    int t ;
    int capacity ;
    PriorityQueue<Node> pq  ;
    HashMap<Integer , Node> hm ;

    public LFUCache(int capacity) {
        
        pq = new PriorityQueue<>( new Comparator<Node>(){
            public int compare(Node n1 , Node n2){
                if(n1.f == n2.f){
                    return (n1.r - n2.r) ;
                }
                else{
                    return (n1.f - n2.f) ;
                }
            }
        }) ;
        hm = new HashMap<>() ;
        t = 0 ;
        this.capacity = capacity ;
    }
    
    public int get(int key) {
        // if(pq.isEmpty() == false ){
        //     System.out.println("time : "+ t + " pq: "+pq.peek().val+","+pq.peek().r+","+pq.peek().f) ;
        // }
        if( hm.containsKey(key) ){
            Node temp = hm.get(key) ;
            pq.remove(temp) ;
            temp.f = temp.f+1 ;
            temp.r = t ;
            pq.add(temp) ;
             t++ ;
            return temp.val ; 
        }
        else{
             t++ ;
            return -1 ;
        }
       
    }
    
    public void put(int key, int value) {
        // if(pq.isEmpty() == false ){
        //     System.out.println("time : "+ t + " pq: "+pq.peek().val+","+pq.peek().r+","+pq.peek().f) ;
        // }       
        int tf = 0 ;
        
        if(hm.containsKey(key)){
            Node temp = hm.get(key) ;
            tf = temp.f ;
            pq.remove(temp) ;
        }
        if(pq.size() == capacity){
            
            hm.remove(pq.peek().key) ;
            pq.remove() ;
        }
        Node newN = new Node(value , t , tf+1 , key) ;
        hm.put(key , newN) ;
        pq.add(newN) ;
        t++ ;
    }
    class Node{
        int val , r , f ,key;
        Node(int val , int r , int f , int key){
            this.f = f ;
            this.val = val ;
            this.r = r ;
            this.key = key ;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */