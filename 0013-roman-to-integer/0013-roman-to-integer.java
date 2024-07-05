class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Pair>hm = new HashMap<>() ;
        hm.put( 'I' , new Pair( 1  , 1) ) ;
        hm.put( 'V' , new Pair( 5  , 2) ) ;
        hm.put( 'X' , new Pair( 10 , 3) ) ;
        hm.put( 'L' , new Pair( 50 , 4) ) ;
        hm.put( 'C' , new Pair( 100 , 5) ) ;
        hm.put( 'D' , new Pair( 500 , 6) ) ;
        hm.put( 'M' , new Pair( 1000, 7) ) ;

        int i = 0 ;
        int ans = 0 ;
        while(i < s.length()-1 ){
            int cp = hm.get(s.charAt(i) ).p ;

            int np = hm.get(s.charAt(i+1) ).p ;
            if(cp >= np){
                ans += hm.get(s.charAt(i) ).v;
                i++ ;
            }
            else{
                ans -= hm.get(s.charAt(i) ).v;
                ans += hm.get(s.charAt(i+1) ).v;
                i = i+2 ;
            }
            
        }
        if( i == s.length()-1){
             ans += hm.get(s.charAt(i) ).v;
        }
        return ans ;
    };

    class Pair {
        int v ;
        // char s ;
        int p ;
        Pair(  int v , int  p ){
            // this.s = s ;
            this.v = v ;
            this.p = p ;
        }
    };
}