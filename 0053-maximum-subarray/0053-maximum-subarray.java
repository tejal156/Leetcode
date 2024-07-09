class Solution {
    public int maxSubArray(int[] nums) 
    {
        int max = Integer.MIN_VALUE ; 
        int curr = 0 ;
        int maxNeg = Integer.MIN_VALUE ;
        int flagNeg = 1 ;

        // if(curr > max )
        // {
        //     max = curr ;
        // }  

        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( curr + nums[i] >= 0)
            {
                curr += nums[i] ;
            }
            else
            {
                curr = 0 ;
            }

            if( max < curr)
            {
                max = curr ;
            }
            if( nums[i]<0)
            {
                if( nums[i] > maxNeg )
                {
                    maxNeg = nums[i] ;
                } 
            }
            else
            {
                flagNeg = 0;
            }
        }

        if( flagNeg == 1)
        {
            return maxNeg ;
        }

        return max ;
    }

}