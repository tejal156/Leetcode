class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer>cutsl =new ArrayList<>() ;
        cutsl.add(0);
        for(int ele : cuts)cutsl.add(ele) ;
        cutsl.add(n) ;
        Collections.sort(cutsl) ;
        int dp[][] = new int[ cutsl.size() ][ cutsl.size() ] ;

        for(int i=0;i<cutsl.size();i++)for(int j=0;j<cutsl.size();j++)dp[i][j]=-1 ;

        return helperFun( cutsl , 1 , cuts.length , dp ) ;

    }

    public int helperFun(ArrayList<Integer>cuts , int i , int j, int dp[][]){
        if(i > j)return 0 ; 
        if(dp[i][j] != -1) return dp[i][j] ;
        int min = Integer.MAX_VALUE ; 
        for(int k = i ; k <= j ; k++){
            int currc = cuts.get(j+1)-cuts.get(i-1);
            currc += helperFun(cuts, i , k-1 , dp ) ;
            currc += helperFun(cuts, k+1 , j, dp ) ;
            min = Math.min(min , currc ) ;
        }
        dp[i][j] = min ;
        // System.out.println(i+" "+j+" "+min);
        return dp[i][j] ;
         
    }



    
}