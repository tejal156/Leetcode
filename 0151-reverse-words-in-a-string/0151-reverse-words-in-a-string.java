class Solution {
    public String reverseWords(String s) {
        
        // s = s.trim() ;
        ArrayList<String> arr = new ArrayList<>() ;
        
        splitFun( arr , s ) ;
        int n = arr.size() ;
        // for(int i = 0 ; i < n/2 ; i++ ){
        //     String temp = arr.get(i) ;
        //     arr.set( i ,arr.get(n-1-i) )  ;
        //     arr.set( n-1-i , temp)  ;
        // }

        StringBuilder str = new StringBuilder() ;

        for(int i = n-1 ; i >= 0 ; i-- ){
            str.append( arr.get(i) ) ;
            str.append(" ") ;
        }

        str.deleteCharAt(str.length() -1 ) ;

        return str.toString() ;
    }

    public void splitFun( ArrayList<String> arr , String str){
        StringBuilder strb = new StringBuilder("") ;

        for(int i = 0 ; i < str.length() ; i++ ){
            if( str.charAt(i) == ' '  ){
                if( strb.toString().equals("") == false  ){
                    arr.add( strb.toString()) ;
                    strb = new StringBuilder("") ;
                }
            }
            else{
                strb.append( str.charAt(i)) ;
            }
        }
                if( strb.toString().equals("") == false  ){
                    arr.add( strb.toString()) ;
                    strb = new StringBuilder("") ;
                }
    }
}