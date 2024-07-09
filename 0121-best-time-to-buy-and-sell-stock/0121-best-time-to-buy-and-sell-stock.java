class Solution {
    public int maxProfit(int[] prices) {
        int s = Integer.MAX_VALUE ;
        int l = Integer.MIN_VALUE ;
        int ans = 0 ;
        for(int i = 0 ; i < prices.length ; i++ ){
            if(prices[i] < s){
                s = prices[i] ;
                l = prices[i] ;
            }
            if( prices[i] > l ){
                l =  prices[i] ;
            }
            ans = Math.max( ans , l-s);
        }
        return ans ;
    }
}