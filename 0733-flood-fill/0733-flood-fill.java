class Solution {
    int ar[] = {0 , 0  , -1 , 1}   ; 
    int ac[] = { 1 , -1 , 0 , 0}   ; 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int tr = image.length ;
        int tc = image[0].length ; 
        int image1[][] = new int[tr][tc]  ;
        for(int r = 0 ; r < tr ; r++){
            for(int c = 0 ; c < tc ; c++){
                image1[r][c] = image[r][c] ;
            }
        }
        if(image[sr][sc] == color)return image1 ; 
        helperFun(image1 , sr , sc , color , image1[sr][sc]) ;
        return image1 ; 
    }

    public void helperFun(int[][] image, int sr, int sc, int color, int oldcolor) {
        image[sr][sc] = color ;
        int tr = image.length ; 
        int tc = image[0].length ; 
        for(int i = 0 ; i <= 3 ; i++ ){
            int nr = sr+ar[i] ;
            int nc = sc+ac[i] ;
            if( nr >= 0 && nc>= 0 &&  nr < tr && nc < tc && image[nr][nc] == oldcolor )helperFun(image , nr , nc , color , oldcolor) ;
        }
    }   
    
}