class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // int nc = colSum.length ; 
        // int nr = rowSum.length ;
        int[][] ans = new int[rowSum.length][colSum.length] ;
        for(int r = 0 ; r < rowSum.length ; r++){
            for(int c  = 0 ; c < colSum.length ; c++){
                int currEle = Math.min(rowSum[r] , colSum[c]) ;
                ans[r][c] =currEle ; 
                rowSum[r] -= currEle ; 
                colSum[c] -= currEle ; 
            }
        } 

        return ans ; 
    }
}