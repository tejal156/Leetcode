class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>() ;
        for(int r = 0;r<matrix.length;r++)
        {
            int min = Integer.MAX_VALUE ;
            int cmin = -1 ;            
            for(int c=0;c<matrix[0].length;c++){

                if(min > matrix[r][c]){
                    min = matrix[r][c] ; cmin = c;
                }
            }

            int max = Integer.MIN_VALUE ;

            for(int cr = 0;cr<matrix.length;cr++) max = Math.max( matrix[cr][cmin],max) ;   

            if(max == min)ans.add(min) ;

        }
        
        return  ans;
    }
}