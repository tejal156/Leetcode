class Solution {
    public String longestPalindrome(String s) {
        // String maxStr = s.charAt(0).toString() ;
        int si = 0 ;
        int ei = 1 ;
        int maxCount = 1 ;
        for(int i = 0 ; i < s.length() ; i++ ){
            int ci = i ;
            int ni = i+1 ;
            int cc = 0 ;

            // for even palindrome
            ni = ci+1 ;
            while( ci >= 0 && ni < s.length() && s.charAt(ci) == s.charAt(ni) ){
                cc += 2 ;
                ci -- ;
                ni ++ ;
            }
            if(maxCount < cc){
                si = ci+1 ;
                ei = ni ;
            }

            // for odd palindrome
            ci = i ;
            ni = i+2 ;
            cc = 1 ;
            while( ci >= 0 && ni < s.length() && s.charAt(ci) == s.charAt(ni) ){
                cc += 2 ;
                ci -- ;
                ni ++ ;
            }
            if(maxCount < cc){
                si = ci+1 ;
                ei = ni ;
            }

        }

        return s.substring(si , ei) ;
    }
}