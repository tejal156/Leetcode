class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>() ;

        for(int i = 0 ; i < s.length() ; i++){
            char currc = s.charAt(i) ;
            if( currc == '(' || currc == '{' || currc == '['  ){
                st.push(currc) ;
            }
            else{
                if(st.isEmpty()){
                    return false ;
                }
                if( currc == ')' && st.peek() == '(' ){
                    st.pop() ;
                }
                else if( currc == '}' && st.peek() == '{' ){
                    st.pop() ;
                }
                else if( currc == ']' && st.peek() == '[' ){
                    st.pop() ;
                }
                else{
                    return false ;
                }
            }
        }

        if(st.isEmpty()){
            return true ;
        }
        else{
            return false ;
        }

    }
}