class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]= new int[grid.length][grid[0].length ] ;
        for(int i = 0;i<grid.length;i++)for(int j =0;j<grid[0].length;j++)dp[i][j]=-1 ;
        return helperFun(grid,0,0,dp) ;
    }

    int helperFun(int grid[][] , int i , int j ,int dp[][]){
        // nr = grid.length ;
        // nc = grid[0].length ;
        if(j >= grid[0].length || i >= grid.length)return Integer.MAX_VALUE ; 
        if(i == grid.length-1 && j == grid[0].length -1) return grid[i][j] ;
        if(dp[i][j] !=-1)return dp[i][j] ;
    
        return dp[i][j] = grid[i][j] + Math.min( helperFun(grid,i,j+1 ,dp ) , helperFun(grid,i+1,j ,dp ) ) ;
    }
}