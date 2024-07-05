class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer>hm = new HashMap<>() ;
        hm.put( 'I' , 1 ) ;
        hm.put( 'V' , 5   ) ;
        hm.put( 'X' , 10  ) ;
        hm.put( 'L' , 50  ) ;
        hm.put( 'C' , 100  ) ;
        hm.put( 'D' , 500  ) ;
        hm.put( 'M' , 1000 ) ;

        int i = 0 ;
        int ans = 0 ;
        while(i < s.length()-1 ){
            int cp = hm.get(s.charAt(i) ) ;

            int np = hm.get(s.charAt(i+1) ) ;
            if(cp >= np){
                ans += cp;
                i++ ;
            }
            else{
                ans -= cp;
                ans += np;
                i = i+2 ;
            }
            
        }
        if( i == s.length()-1){
             ans += hm.get(s.charAt(i) );
        }
        return ans ;
    };


}