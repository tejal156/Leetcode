class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()] ;
        return helperFun(s , wordDict , 0,dp );
    }

    public boolean helperFun(String s, List<String> wordDict , int si ,int dp[]){
        if( si == s.length() )return true ; 

        if(dp[si]!= 0 )return (dp[si]==1)? true : false ; 

        for(int i=0 ; i < wordDict.size();i++){
            if( s.startsWith(wordDict.get(i) , si ) ){
                if(  helperFun(s , wordDict , si+wordDict.get(i).length() ,dp)  ){
                    dp[si] = 1 ;
                    return true ; 
                }
            }
        }
        dp[si] = -1 ;
        return false ; 
    }
}