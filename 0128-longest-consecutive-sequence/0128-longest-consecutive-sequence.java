class Solution {
    public int longestConsecutive(int[] nums) {
        
        // initialization 
        HashSet<Integer>hs = new HashSet<>() ;
        boolean isEnd[] = new boolean[nums.length] ;
        int ans = 0 ;

        // fill hs
        for(int num : nums )hs.add(num) ;

        // fill isend
        for(int i=0;i<nums.length;i++)isEnd[i] = (hs.contains(nums[i]+1)? false : true ) ;
    
        // find ans 
        for(int i=0;i<nums.length;i++){
            if(isEnd[i] == true){
                int cans = 0 ; 
                int currnum = nums[i] ; 
                while( hs.contains(currnum )  ){
                    currnum-- ;
                    cans ++ ; 
                }
                ans = Math.max(ans , cans ) ;
            }
        }

        return ans ; 
    }
}