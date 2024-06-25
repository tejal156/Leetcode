class Solution {
    public boolean isValid(String s) 
    {
        // logic :
        // traver given str as curr 
        Stack< Character > s1 = new Stack<>() ;
        for( int i = 0 ; i < s.length() ; i++ )
        {
            char curr = s.charAt(i) ;
            
            // if curr is opening P thn push in stack
            if( curr == '(' || curr == '{' || curr == '[' )
            {
                s1.push(curr) ;
            }
            else if( curr == ')' || curr == ']' || curr == '}' )
            {
                // it it is closing thn 
                // pop peek and chk if it not valid  thn false
                // if empty thn false
                if( s1.empty() == true)
                {
                    return false ;
                }
                char top = s1.pop() ;
                switch( curr )
                {
                    case ')':
                    if( top != '(')
                    {
                        return false ;
                    }
                    break ;

                    case ']':
                    if( top != '[')
                    {
                        return false ;
                    }
                    break ;

                    case '}':
                    if( top != '{')
                    {
                        return false ;
                    }
                    
                    break ;

                }
 
            }

        }
        
        
        if( s1.empty() == false )
        {
            return false ;
        }
        // loop enf
        // is stack not empty thn fasle
        return true ;
        // at last return true

    }
}