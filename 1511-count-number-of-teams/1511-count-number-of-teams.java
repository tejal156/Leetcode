class Solution {
    public int numTeams(int[] rating) {
        int ans = 0 ; 

        for(int i=0;i<rating.length;i++){

            int rl = 0 , rm = 0 , ll = 0 , lm = 0 ; 
            for(int j=0 ; j <= i-1;j++){
                if( rating[j] < rating[i])ll++ ;
                else if( rating[j] > rating[i])lm++ ;
            }
            for(int j=i+1 ; j <= rating.length-1;j++){
                if( rating[j] < rating[i])rl++ ;
                else if( rating[j] > rating[i])rm++ ;
            }
            ans += (rl*lm + ll*rm) ;
        }
        return ans ; 
    }
}