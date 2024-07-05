class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort( strs) ;
        String fstr = strs[0] ;
        String estr = strs[ strs.length -1 ] ;
        int n = Math.min( fstr.length() , estr.length() ) ;
        StringBuilder cstr = new StringBuilder() ;
        for(int i = 0 ; i < n ; i++){
            if( fstr.charAt(i) == estr.charAt(i) ){
                cstr.append(  fstr.charAt(i) ) ;
            }
            else{
                return cstr.toString() ;
            }
        }

        return cstr.toString() ;
    }
}