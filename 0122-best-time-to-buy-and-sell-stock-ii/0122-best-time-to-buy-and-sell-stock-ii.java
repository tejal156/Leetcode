class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length ; 
        int dp[][]= new int[n][2] ;

        for(int i=0;i<n;i++)for(int j=0;j<2;j++)dp[i][j] = -1 ;
        return helperFun(0 , 0 , prices , dp) ;
    }

    public int helperFun(int s , int cd , int parr[] , int dp[][] ){
        if(cd == parr.length)return 0 ;
        if(dp[cd][s] != -1 ) return dp[cd][s] ; 
        int max = 0 ; 
        // max = Math.max(max ,  ) ;

        // if you can buy stock
        if(s == 0 ){
            max = Math.max(max , helperFun( 1, cd+1 , parr , dp)- parr[cd] ) ;
            max = Math.max(max , helperFun( 0, cd+1 , parr , dp)) ;
        }

        // if s is 1 
        if(s == 1 ){
            // sell it
            max = Math.max(max , helperFun( 0, cd+1 , parr , dp)+ parr[cd] ) ;
            max = Math.max(max , helperFun( 1, cd+1 , parr , dp)) ;
        }    

        return dp[cd][s]  = max ; 
    }
}