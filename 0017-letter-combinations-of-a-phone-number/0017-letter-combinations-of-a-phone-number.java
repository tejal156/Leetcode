class Solution {

    final static char arrDs[][] = { {' '} , {} , { 'a' ,'b' , 'c'} , { 'd' , 'e' , 'f'} , { 'g', 'h' ,'i' } , { 'j' , 'k' , 'l' } , { 'm' , 'n' , 'o' } , { 'p' , 'q' , 'r' , 's' } , { 't' , 'u' , 'v' } , { 'w' , 'x' , 'y' , 'z'} } ;

    final static void fun( String digits , int indexDigits , List<String> ans , StringBuilder curr)
    {
        if( indexDigits == digits.length() )
        {
            ans.add(curr.toString()) ;
            return ;
        }

        int currNum = Integer.parseInt(  (new Character(digits.charAt(indexDigits))).toString()) ;
        char temp[] = arrDs[ currNum ] ;
        for( int i = 0 ;  i < temp.length ;i++ )
        {
            // StringBuilder temp2 = curr ;
            fun(digits , (indexDigits +1)  , ans , curr.append( temp[i])) ;
            curr.deleteCharAt(curr.length() - 1);
        }

    } ;

    public List<String> letterCombinations(String digits) 
    {
        List<String> ans = new ArrayList<>() ;
        if( digits.length() == 0 )
        {
            return ans ;
        }
        else
        {
            StringBuilder temp1 = new StringBuilder("") ;
            fun(digits , 0 , ans , temp1 ) ;
        } 
        return ans ;
    }
}