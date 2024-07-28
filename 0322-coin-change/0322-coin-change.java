class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1] ;
        for( int r = 0 ; r < coins.length ; r++ )for( int c = 0 ; c < amount+1 ; c++ )
                dp[r][c] = -1 ; 
            
        int ans = helperFun( coins , amount , 0,dp) ;
        return ( ans == Integer.MAX_VALUE ? -1 : ans) ;
    }
    public int helperFun(int[] coins, int ra, int ci,int dp[][] ){
        if(ra == 0) return 0 ;
        if(ci == coins.length )return Integer.MAX_VALUE ; 
        if(dp[ci][ra] != -1) return dp[ci][ra] ; 
        
        int ac = Integer.MAX_VALUE ; 
        if( coins[ci] <= ra){
            ac = helperFun(coins , ra-coins[ci] , ci ,dp);
            ac = ( ac == Integer.MAX_VALUE ? Integer.MAX_VALUE : ac+1  ) ; 
        }

         return dp[ci][ra] = Math.min( ac ,  helperFun(coins , ra , ci+1 ,dp) ) ;    

        
    }
}