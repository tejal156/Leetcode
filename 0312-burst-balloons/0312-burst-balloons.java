class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length ; 
        ArrayList<Integer>arr = new ArrayList<>() ;
        arr.add(1) ;

        for(int num : nums )arr.add(num) ;
        arr.add(1);

        int dp[][] = new int[nums.length+1][nums.length+1] ;

        for(int i=0;i<n+1;i++)for(int j=0;j<n+1;j++)dp[i][j] =-1 ; 

        return helperFun(1 , nums.length , arr , dp) ;
    }

    public int helperFun( int i , int j , ArrayList<Integer>arr , int dp[][]){
        if(i > j)return 0 ; 
        if(dp[i][j] !=-1)return dp[i][j] ;
        int max = 0 ;
        for(int k = i ; k <= j ; k++){
            int currSum = arr.get(k) * arr.get(i-1) * arr.get(j+1) +
            helperFun(i,k-1, arr,dp) + helperFun(k+1 , j, arr , dp) ;
            max = Math.max(max , currSum) ;
        }
        return dp[i][j] = max ; 
    }
}