class Solution {
    public int maximalRectangle(char[][] matrix) {

        int ans = 0 ; 
        int arr[] = new int[matrix[0].length] ;
        for(int i = 0 ; i < matrix.length ; i++){
            
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == '1')arr[j]++ ;
                else arr[j] = 0 ;
            }
            ans = Math.max(ans , largestRectangleArea(arr)) ;
       }

       return ans ; 
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st = new Stack<>() ;
        int ans = Integer.MIN_VALUE ;
        int currv ;
        for( int i = 0 ; i <= heights.length ; i++){

            if(i==heights.length){ currv =Integer.MIN_VALUE ; }
            else{
                currv = heights[i] ;
            }
            
            if( st.isEmpty()){
                st.push(i);
            }
            else if( heights[ st.peek()] < currv){
                st.push(i) ;
            }
            else{
                int r = i ;
                int l = -1 ;
                while( st.isEmpty() == false && heights[ st.peek()] >= currv ){
                    l = -1;
                    int pushv = st.peek() ;
                    st.pop() ;
                    if(st.isEmpty() == false) l = st.peek() ;
                    int currh = ( r -l -1 )* heights[pushv] ;
                    // System.out.println(" pop : " + heights[pushv] + " currh :"+ currh) ;
                    ans = Math.max( currh , ans) ;
                }
                st.push(i) ;
            }
        }

        return ans ;
    }
    
}