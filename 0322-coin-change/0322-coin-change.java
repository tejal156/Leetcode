class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1] ;
        for( int r = 0 ; r < coins.length ; r++ ){
            for( int c = 0 ; c < amount+1 ; c++ ){
                dp[r][c] = -2 ; 
            }
        }
        return helperFun( coins , amount , 0,dp) ;
    }
    public int helperFun(int[] coins, int ra, int ci,int dp[][] ){
        if(ra == 0) return 0 ;
        if(ci == coins.length )return -1 ; 
        if(dp[ci][ra] != -2) return dp[ci][ra] ; 
        if( coins[ci] <= ra ){
            int ac = 1+helperFun(coins , ra-coins[ci] , ci ,dp);

            int nac = helperFun(coins , ra , ci+1 ,dp) ;
             
            if( ac == 0  ) dp[ci][ra] = nac ; 
            else if(nac == -1)dp[ci][ra] = ac ; 
            else dp[ci][ra] = Math.min( ac , nac ) ;
            return dp[ci][ra]  ;
        } 
        else{
            dp[ci][ra] = helperFun(coins , ra , ci+1 ,dp) ;
            return dp[ci][ra] ; 
        }
        
    }
}