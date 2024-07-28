class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1 ) return 0 ;
        int dp[][] = new int[ obstacleGrid.length ][ obstacleGrid[0].length ] ;
        for(int i=0;i<obstacleGrid.length;i++)for(int j=0;j<obstacleGrid[0].length;j++) dp[i][j] = -1 ; 

        return helperFun(0,0,obstacleGrid,dp) ;
    }

    public int helperFun(int i , int j , int arr[][] , int dp[][]){
        // nr - arr.length 
        // nc - arr[0].length
        if(i == arr.length-1 && j == arr[0].length-1 )return 1 ; 
        if(i >= arr.length || j >= arr[0].length)return 0 ;
        if(arr[i][j]== 1)return 0 ; 
        if(dp[i][j]!=-1)return dp[i][j] ;

        return dp[i][j] = helperFun(i , j+1 , arr,dp) + helperFun(i+1 , j , arr ,dp) ;
    }
}