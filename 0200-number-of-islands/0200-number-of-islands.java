class Solution {
    public int numIslands(char[][] grid) {
        int nr = grid.length ; 
        int nc = grid[0].length ; 
        int ans = 0 ; 
        boolean isVisited[][] = new boolean[nr][nc] ;

        for(int i = 0 ; i < nr ; i++)for(int j = 0 ; j < nc ; j++) if(isVisited[i][j] == false && grid[i][j] == '1'){
            ans ++ ;
            dfs(grid , i , j , isVisited ) ;
        }

        return ans ; 
    }

    public void dfs(char[][] grid , int r , int c , boolean isVisited[][] ){
        isVisited[r][c] = true ; 

        int addr[] = {-1  , 0 , 1 , 0 } ;
        int addc[] = { 0 , 1 , 0 , -1 } ;
        for(int i = 0 ; i < 4 ; i++){
            int nr = r + addr[i] ;
            int nc = c + addc[i] ;
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && isVisited[nr][nc] == false && grid[nr][nc] == '1'){
                dfs(grid ,  nr  , nc , isVisited ) ;
            }
        }

    }
}