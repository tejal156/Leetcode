class Solution {
    public int minimumDeletions(String s) {

        int dp[][] = new int[s.length()][2] ;

        for(int i=0;i<s.length();i++) for(int j=0;j<2;j++)dp[i][j] = -1 ;

        return helperFun( s , 0 , true ,dp ) ;
    }

    public int helperFun( String s , int is , boolean isa ,int dp[][]){
        if(is == s.length())return 0 ; 

        if(dp[is][ (isa==true?1:0)] != -1)return dp[is][ (isa==true?1:0)] ;

        // if it is in a part
        if(isa == true){
            if(s.charAt(is) != 'a'){
                // delete char 
                int temp1 = 1 + helperFun(s,is+1,isa,dp) ;

                // change flag 
                int temp2 = helperFun(s,is+1,false,dp) ;
                return dp[is][ (isa==true?1:0)] = Math.min(temp1 , temp2 ) ;
            }
        }
        else{
            if(s.charAt(is) != 'b') return dp[is][ (isa==true?1:0)] = helperFun(s,is+1,isa,dp)+1 ;
        }

        return dp[is][ (isa==true?1:0)] = helperFun(s,is+1,isa,dp) ;

    }
}