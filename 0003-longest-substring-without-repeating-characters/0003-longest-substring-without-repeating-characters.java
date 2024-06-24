class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxl = 0 ;
        HashSet<Character> hs = new HashSet<>() ;
        int l = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            
            if( hs.contains( s.charAt(i) ) ){
                while( hs.contains( s.charAt(i) ) ){
                    hs.remove( s.charAt(l) ) ;
                    l++ ;
                }
            
            }
            
            maxl = Math.max( maxl , i-l+1 ) ;
            
            hs.add( s.charAt(i) ) ;

            
            
        }

        return maxl ;
    }
}