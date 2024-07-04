class Solution {
    public int orangesRotting(int[][] grid) {
        int total_or = 0 ;
        Queue<Pair> q = new LinkedList<>() ;
        int tr = grid.length ;
        int tc = grid[0].length ;

        for(int r = 0 ; r < tr ; r++){
            for(int c = 0 ; c < tc ; c++ ){
                if(grid[r][c] == 2 ){
                    q.add( new Pair( r , c) ) ;
                }
                if(grid[r][c] != 0){
                    total_or ++ ;
                }
            }
        }

        int t_cal_or = 0 ;
        int td = 0 ;
        while(q.isEmpty() == false ){
            int size = q.size() ;
            t_cal_or += size ;
            for(int i = 0 ; i < size ; i++ ){
                Pair currP = q.remove() ;
                //  top , bottom , left , right 
                int arr_r[] = { -1 , 1 , 0 , 0  } ;
                int arr_c[] = { 0  , 0 , -1 , 1 } ;
                for(int j = 0 ; j <= 3 ; j++ ){
                    int ni = currP.r + arr_r[j] ;
                    int nj = currP.c + arr_c[j] ;
                    System.out.println(td +" : "+ ni + " "+ nj) ;
                    if(ni >= 0 && ni < tr && nj >= 0 && nj<tc && grid[ni][nj] == 1){
                        grid[ni][nj] = 2 ;
                        q.add( new Pair( ni , nj) ) ;
                    }
                }
            }
            if(q.isEmpty() == false ){
                td ++ ;
            }
            
        }
        System.out.println( t_cal_or + " "+ total_or) ;
        if( t_cal_or == total_or ){
            return td ;
        } 
        return -1 ;

    }

    class Pair{
        int r , c ;
        Pair(int r , int c){
            this.r = r ;
            this.c = c ;
        }
    }
}