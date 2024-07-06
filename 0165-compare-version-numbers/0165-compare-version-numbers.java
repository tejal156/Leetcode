class Solution {
    public int compareVersion(String version1, String version2) {
        int v1i = 0 ;
        int v2i = 0 ;
        int v1n = version1.length() ;
        int v2n = version2.length() ;
        while( v1i < v1n && v2i < v2n ){
            int arr1[] = helperFun(  version1 , v1i) ;
            int arr2[] = helperFun( version2 , v2i) ;
            if( arr1[0] > arr2[0]){
                return 1 ; 
            }
            else if( arr1[0] < arr2[0] ){
                return -1 ; 
            }
            v1i = arr1[1] ;
            v2i = arr2[1] ;
        }

        if(v1i < v1n){
            for(int i = v1i ; i < v1n ; i++){
                if( version1.charAt(i) != '.' && version1.charAt(i) != '0'  ){
                    return 1 ;
                }
            }
        }
        if(v2i < v2n ){
            for(int i = v2i ; i < v2n ; i++){
                if( version2.charAt(i) != '.' && version2.charAt(i) != '0'  ){
                    return -1 ;
                }
            }
        }
        return 0 ;
    }

    public int[] helperFun(  String version , int vi){
        while( vi < version.length() && version.charAt(vi)!='.' && version.charAt(vi)=='0' ){
            vi ++ ;
        }
        StringBuilder str = new StringBuilder() ;
        while( vi < version.length() && version.charAt(vi)!='.' ){
            str.append( version.charAt(vi) ) ;
            vi ++ ;
        } 

        if( vi != version.length()){
            vi ++ ;
        }

        if( str.length() == 0){
            int ans[] = { 0, vi} ;
            return ans ;
        }

        int ans[] = { Integer.parseInt(str.toString() ) , vi} ;
        return ans ; 
    } ;
}