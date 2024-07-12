class Solution {
    public int lengthOfLIS(int[] nums) {
        int nums1[] = new int[nums.length] ;
        int index= 0 ;
        for(int ele:nums)nums1[index++]=ele ;
        Arrays.sort(nums1);
        for(int i=1;i<nums1.length;i++)if(nums1[i]==nums1[i-1])nums1[i-1]=-100000 ;

        int dp[][] = new int[nums.length ][nums.length] ;
        for(int i = 0 ; i < nums.length ; i++ ){
            for( int j = 0 ; j < nums.length ; j++ ){
                dp[i][j] =-1 ;
            }
        }
        return helperFun(nums , nums1 , 0 , 0 , dp) ;

    }

    public int helperFun(int[] text1, int[] text2,int i1 , int i2 , int dp[][] ){
        if( i1 >= text1.length || i2 >= text2.length )return 0 ; 
        if(dp[i1][i2] != -1)return dp[i1][i2] ;
        int max = -100000 ; 

        if( text1[i1] == text2[i2] ) max = Math.max( max , 1+ helperFun(text1 , text2 , i1+1 , i2+1 , dp)) ;

        max = Math.max( max ,  helperFun(text1 , text2 , i1 , i2+1 , dp)) ;
        max = Math.max( max ,  helperFun(text1 , text2 , i1+1 , i2, dp )) ;

        dp[i1][i2] = max ;
        return dp[i1][i2] ; 
    }
}