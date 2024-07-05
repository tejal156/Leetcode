class Solution {
    public void setZeroes(int[][] matrix) {
        int tr = matrix.length ;
        int tc = matrix[0].length ; 

        boolean is_row0 = false  ;
        boolean is_col0 = false  ;
        // set flag for is 0th row will contains all 0s
        for( int c = 0 ; c < tc ; c++){
            if( matrix[0][c] == 0){
                is_row0 = true ;
                break ;
            }
        }

        // set flag for is 0th col will contains all 0s
        for( int r = 0 ; r < tr ; r++){
            if( matrix[r][0] == 0){
                is_col0 = true ;
                break ;
            }
        }

        for(int r = 1 ; r < tr ; r++  ){
            for( int c = 1 ; c < tc ; c++ ){
                if( matrix[r][c] == 0){
                    matrix[r][0] = 0 ;
                    matrix[0][c] = 0 ;
                }
            }
        }



        // doing column 0 
        for(int c = 1 ; c < tc ; c++){
            if( matrix[0][c] == 0 ){
                for(int r = 1 ; r < tr ; r++ ){
                    matrix[r][c] = 0 ;
                }
            }
        }

        // doing row 0 
        for(int r = 1 ; r < tr ; r++){
            if( matrix[r][0] == 0 ){
                for(int c = 1 ; c < tc ; c++ ){
                    matrix[r][c] = 0 ;
                }
            }
        }

        if( is_row0 == true ){
            for( int c = 0 ; c < tc ; c++){
                matrix[0][c] = 0 ;
            }
        }

        if( is_col0 == true ){
            for( int r = 0 ; r < tr ; r++){
                matrix[r][0] = 0 ;
            }
        }


    }
}