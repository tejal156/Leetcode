class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mxc = 0 ;
        int c = 0 ;
        for(int i = 0; i < nums.length ; i++){
            if( nums[i] == 1){
                c++ ;
            }
            else{
                mxc = Math.max( mxc , c ) ;
                c = 0;
            }
            
        }
        
        return Math.max( mxc , c ) ;
    }
}