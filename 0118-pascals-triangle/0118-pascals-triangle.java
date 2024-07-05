class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>() ;
        for(int i = 1 ; i <= numRows ; i++ ){
            ans.add( helperFun(i) ) ;
        }
        return ans ; 
    }

    public List<Integer> helperFun(int numRows){
        List<Integer> ans = new ArrayList<>() ;
        ans.add(1) ;
        int u = numRows-1 ;
        int l = 1 ;
        for(int i = 0 ; i <= numRows-2 ; i++ ){
            int currEle = ans.get( ans.size() -1 ) * u ;
            currEle /= l ;
            ans.add( currEle ) ;
            u-- ;
            l++ ;
        }

        for(int i = 0 ; i < ans.size()/2 ; i++){
            int temp = ans.get(i) ;
            ans.set(  i , ans.get(ans.size()-1- i) ) ;
            ans.set( ans.size()-1- i, temp) ;
        }
        return ans ; 
    }
}