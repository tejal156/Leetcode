class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() ][text2.length()] ;
        for(int i = 0 ; i < text1.length() ; i++ ){
            for( int j = 0 ; j < text2.length() ; j++ ){
                dp[i][j] =-1 ;
            }
        }
        return helperFun(text1 , text2 , 0 , 0 , dp) ;
    }

    public int helperFun(String text1, String text2,int i1 , int i2 , int dp[][] ){
        if( i1 >= text1.length() || i2 >= text2.length() )return 0 ; 
        if(dp[i1][i2] != -1)return dp[i1][i2] ;
        int max = 0 ; 
        if( text1.charAt(i1) == text2.charAt(i2) )return  dp[i1][i2] = 1+ helperFun(text1 , text2 , i1+1 , i2+1 , dp) ;
        max = Math.max( max ,  helperFun(text1 , text2 , i1 , i2+1 , dp)) ;
        max = Math.max( max ,  helperFun(text1 , text2 , i1+1 , i2, dp )) ;
        // System.out.println(i1 + " "+i2+" "+max) ;
        // dp[i1][i2] = max ;
        return dp[i1][i2] = max ;
    }
}