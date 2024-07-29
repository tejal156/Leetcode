class Solution {
    public int maxProfit(int[] prices) {
        int s = Integer.MAX_VALUE ; 
        int ans = 0 ; 
        for( int i = 0 ; i < prices.length;i++){
            s = Math.min(s , prices[i]) ;
            ans = Math.max( ans , prices[i]-s ) ;
        }
        return ans ; 
    }
}