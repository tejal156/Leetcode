class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]= new int[grid.length][grid[0].length ] ;
        for(int i = 0;i<grid.length;i++)for(int j =0;j<grid[0].length;j++)dp[i][j]=-1 ;
        return helperFun(grid,0,0,dp) ;
    }

    int helperFun(int grid[][] , int i , int j ,int dp[][]){
        // nr = grid.length ;
        // nc = grid[0].length ;
        if(i == grid.length-1 && j == grid[0].length -1) return grid[i][j] ;
        if(dp[i][j] !=-1)return dp[i][j] ;
        int min = Integer.MAX_VALUE ; 

        // if right possible ni = i . nc = j+1
        if(j+1 < grid[0].length){
            min = Math.min(min , helperFun(grid,i,j+1 ,dp ) ) ;
        }

        // goes down
        if(i+1 < grid.length){
            min = Math.min(min , helperFun(grid,i+1,j ,dp ) ) ;
        }
        dp[i][j] = grid[i][j]+min ;
        return dp[i][j] ;
    }
}