class Solution {
    public int longestPalindromeSubseq(String s) {

        StringBuilder s2 = new StringBuilder("") ;
        for(int i = s.length()-1;i>= 0 ;i--)s2.append( s.charAt(i)) ;
        String s1 = s2.toString() ;
        
        int dp[][] = new int[s.length() ][s2.length()] ;
        for(int i = 0 ; i < s.length() ; i++ )for( int j = 0 ; j < s2.length() ; j++ )
                dp[i][j] =-1 ;
            
        
        return helperFun(s , s1 , 0 , 0 , dp) ;        
    }

    public int helperFun(String text1, String text2,int i1 , int i2 , int dp[][] ){
        if( i1 >= text1.length() || i2 >= text2.length() )return 0 ; 
        if(dp[i1][i2] != -1)return dp[i1][i2] ;
        int max = 0 ; 
        if( text1.charAt(i1) == text2.charAt(i2) ) max = Math.max( max , 1+ helperFun(text1 , text2 , i1+1 , i2+1 , dp)) ;
        max = Math.max( max ,  helperFun(text1 , text2 , i1 , i2+1 , dp)) ;
        max = Math.max( max ,  helperFun(text1 , text2 , i1+1 , i2, dp )) ;
        return dp[i1][i2] = max; 
    }


}