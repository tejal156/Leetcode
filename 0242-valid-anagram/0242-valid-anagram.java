class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer>hm = new HashMap<>(); 
        if(s.length() != t.length() ){
            return false ;
        }
        for(int i = 0 ; i < s.length() ; i++ ){
            Integer val = hm.get( s.charAt(i)) ;
            if( val != null ){
                hm.put( s.charAt(i) , val+1) ;
            }
            else{
                hm.put( s.charAt(i) , 1) ;
            }
        }

        for(int i = 0 ; i < t.length() ; i++ ){
            
            Integer val = hm.get( t.charAt(i) ) ;
            if( val == null ){

                return false ;
            }
            else if( val == 0 ){
                return false ;
                
            }
            else{
                hm.put( t.charAt(i) , val-1 ) ;
            }
        }
        return true ; 

    }
}