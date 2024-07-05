class Solution {
    public int myAtoi(String s) {

        s = s.trim() ;

        if(s.length() == 0 ){
            return 0 ;
        }

        
        StringBuilder num = new StringBuilder() ;
        char sign = ' ' ;
        HashSet<Character> nums = new HashSet<>() ;
        nums.add('0') ; nums.add('1') ; nums.add('2') ; nums.add('3') ; nums.add('4') ;
        nums.add('5') ; nums.add('6') ; nums.add('7') ; nums.add('8') ; nums.add('9') ;

        // handling sign
        char currc = s.charAt(0) ;
        if( currc == '+'  || currc == '-'){
            sign = currc ;
        }
        else if( nums.contains(currc) ){
            num.append(currc) ;
        }
        else{
            return 0 ;
        }

        // handling rest of String 
        for(int i = 1 ; i < s.length() ; i++ ){
            currc = s.charAt(i) ;
            if( nums.contains(currc) ){
                num.append(currc) ;
            }
            else{
                break;
            }           
        }

        // delete 0 at start
        int i = 0 ;
        while(  num.length()!= 0 && num.charAt(i) == '0'){
            num.deleteCharAt(0) ;
        }
 
        //  remove empty and long string
        if( num.length() == 0){
            return 0 ; 
        }
        if(num.length() >= 11 ){
            if( sign == '-'){
                return Integer.MIN_VALUE ;
            }
            else{
                return  Integer.MAX_VALUE ;
            }
        }

        
        // convert to number
        long range = Long.parseLong( num.toString() ) ;
        int ans = 0 ;

        // change sign
        if(sign == '-'){
            range = -1l * range ;
        }

        if( range >= (long)Integer.MAX_VALUE  ){
            ans = Integer.MAX_VALUE ;
        }
        else if(range <= (long)Integer.MIN_VALUE ){
            ans = Integer.MIN_VALUE ;
        }
        else{
            ans = (int) range ;             
        }

        return ans ; 

    }
}