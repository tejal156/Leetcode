class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        ArrayList<ArrayList<ArrayList<Integer>>>adj = new ArrayList<>() ;
        int dis[][] = new int[26][26] ;

        // fill adj
        for(int i =0;i<26;i++)adj.add(new ArrayList<>() ) ;

        for(int i = 0;i<original.length;i++){
            ArrayList<Integer>temp = new ArrayList<>() ;
            temp.add(changed[i]-'a') ;
            temp.add(cost[i]) ;
            adj.get( original[i] -'a').add( temp ) ;
        }

        //fill dis  
        for(int i=0;i<26;i++)dijkstra( 26,adj,i,dis[i]) ;

        long ans = 0l ; 
        for(int i = 0 ; i < source.length() ;i++){
            if(dis[source.charAt(i)-'a'][target.charAt(i)-'a'] == Integer.MAX_VALUE ){
                return (long)(-1) ;
            }
            else{
                ans = ans + (long)dis[source.charAt(i)-'a'][target.charAt(i)-'a'] ;
            }
        }

        return ans ; 
    }

    static void dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S , int dis[])
    {
        // Write your code here
        // ds initialization
        // pq => [dis , v]
        PriorityQueue<int[]> pq = new PriorityQueue( new Comparator<int[]>(){
            public int compare( int a1[] , int a2[]){
                return a1[0] - a2[0] ;
            }
        }) ;
        
        // adding source node 
        for(int i = 0 ;i<V;i++)dis[i] = Integer.MAX_VALUE ; 
        pq.add( new int[]{0 , S} ) ;
        dis[S] = 0 ; 
        
        // fill dis
        while(pq.isEmpty() == false ){
            int curra[] = pq.remove() ;
            int currd = curra[0] ;
            int currv = curra[1] ;
            // chk for neighbour 
            for(int i = 0 ; i < adj.get(currv).size() ; i++ ){
                int nv = adj.get(currv).get(i).get(0) ;
                int ntd = adj.get(currv).get(i).get(1)+currd ;
                if( ntd < dis[nv] ){
                    pq.add(new int[]{ntd , nv }) ;
                    dis[nv] = ntd ; 
                } 
                
            }
        } ;
        
        
    }

}