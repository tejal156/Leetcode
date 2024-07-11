class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        for(int ele : nums ){
            if(pq.size() < k || pq.peek() < ele )pq.add( ele) ;
            if(pq.size() > k )pq.remove() ;
        }
        return pq.peek() ;
    }
}