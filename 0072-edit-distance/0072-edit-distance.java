class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() ][word2.length()] ;
        for(int i=0 ; i<word1.length() ;i++)for(int j =0;j<word2.length();j++)dp[i][j]=-1 ;
        
        return  helperFun(word1 , word2 , 0 , 0,dp ) ;
    }

    public int helperFun(String w1, String w2,int i1 , int i2, int dp[][] ){
        if( i1 == w1.length() && i2 == w2.length() )return 0 ; 
        if( i1 == w1.length() )return w2.length()-i2 ;
        if( i2 == w2.length() )return w1.length()-i1 ;

        if(dp[i1][i2]!= -1)return dp[i1][i2] ;
        int min = Integer.MAX_VALUE ;
        if( w1.charAt(i1) == w2.charAt(i2) )min = Math.min(min , helperFun(w1 , w2 , i1+1 , i2+1,dp ) ) ;
        // add
        min = Math.min(min , helperFun(w1 , w2 , i1 , i2+1,dp )+1 ) ;
        // delete
        min = Math.min(min , helperFun(w1 , w2 , i1+1 , i2,dp )+1 ) ;
        // replace
        min = Math.min(min , helperFun(w1 , w2 , i1+1 , i2+1 ,dp)+1 ) ;
        // System.out.println(i1+" "+i2+" "+min) ;
        dp[i1][i2] = min ;
        return min ; 
    }

}