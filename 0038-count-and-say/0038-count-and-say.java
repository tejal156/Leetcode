class Solution {
    public String countAndSay(int n) {

        if(n == 1 ){
            return "1" ;
        }
        else if(n ==2 ){
            return "11" ;
        }
        StringBuilder str = new StringBuilder() ;
        str.append(11) ;
        for(int i = 2 ; i < n ; i++ ){
            StringBuilder nstr = new StringBuilder() ;
            int c = 0  ;
            int j ;
            for( j = 0 ; j < str.length()-1 ; j++ ){
                if( str.charAt(j) == str.charAt(j+1)  ){
                    c++ ;
                }
                else{
                    
                    nstr.append(c+1) ;
                    nstr.append(str.charAt(j)) ;
                    c = 0 ;
                }
            }
            if(c!= 0 ){
                nstr.append(c+1) ;
                nstr.append(str.charAt(j)) ;
            }
            if( str.charAt(j) != str.charAt(j-1)  ){
                nstr.append(1) ;
                nstr.append(str.charAt(j)) ;
            }

            str = nstr ; 
            // System.out.println(i+" : "+str);
        }
        return str.toString() ;
    }
}