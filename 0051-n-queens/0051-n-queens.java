class Solution {
    public List<List<String>> solveNQueens(int n) {
        // creating ans list
        List<List<String>> currL = new ArrayList<>() ;
        List<String> temp = new ArrayList<>() ;
        List<List<String>> ans = new ArrayList<>() ;
        // StringBuilder str = new StringBuilder() ;
        for(int i = 0 ; i < n ; i++){
            temp.add(".") ;
        }
        for(int i = 0 ; i < n ; i++){
            currL.add( new ArrayList<>(temp) ) ;
        }
        
        helperFun( ans , currL , n , 0) ;
        return ans ;
    }

    public void helperFun( List<List<String>> ans , List<List<String>> currL ,int n , int cr  ){
        if( cr == n){
            ans.add( convertToList(currL) ) ;
            return ;
        }

        for(int i = 0 ; i < n ; i++ ){
            // System.out.println("row"+cr+"col"+i) ;
            if( isSafe( currL , cr , i , n ) ){
                currL.get(cr).set(i,"Q") ;
                helperFun( ans , currL , n , cr+1) ;
                currL.get(cr).set(i,".") ;;
            }
        }
    }

    public boolean isSafe( List< List<String>> currL , int cr , int  i , int n){
        int r = cr ; 
        int c = i ;
        while(r != -1){
            if( currL.get(r).get(c).equals("Q") ){
                return false ;
            }
            r-- ;
        }

        r = cr ; 
        c = i ;
        while(r != -1 && c != -1){
            if( currL.get(r).get(c).equals("Q") ){
                return false ;
            }
            r-- ;
            c-- ;
        }

        r = cr ; 
        c = i ;
        while(r != -1 && c != n){
            if( currL.get(r).get(c).equals("Q") ){
                return false ;
            }
            r-- ;
            c++ ;
        }
        return true ;

    }

    public List<String> convertToList(List<List<String>> currL){

        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < currL.size() ; i++){
            List<String> temp = currL.get(i) ;
            StringBuilder str = new StringBuilder() ;
            for(int j = 0 ; j < temp.size() ; j++){
                str.append(temp.get(j) );
            }
            ans.add( str.toString()) ;
        }
        return ans ;
    }


}
