class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer>hm = new HashMap<>() ;

        for(int i = 0 ; i < nums.length ; i++ ){
            if(hm.containsKey(nums[i] ) ){
                int f = hm.get(nums[i]);
                hm.put( nums[i] , f + 1) ;
            }
            else{
                hm.put(nums[i] , 1 ) ;
            }
        }

        PriorityQueue<int[]> pq  = new PriorityQueue<>( new Comparator<int[]>(){
            public int compare( int arr1[] , int arr2[]){
                return arr1[1] - arr2[1] ;
            }
        }) ;

        for( int key : hm.keySet() ){
            int tempArr[] = { key , hm.get(key) } ;
            pq.add( tempArr) ;
            if(pq.size()>k){
                pq.remove() ;
            }
        }
        int ans[] = new int[k] ;
        int ansi = 0 ;

        while(pq.size() > 0){
            ans[ ansi ] = pq.remove()[0] ;
            ansi++ ;
        }
        return ans ; 

    }
}