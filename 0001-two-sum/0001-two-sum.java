class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        for(int i = 0 ; i < nums.length ; i++ ){
            // complement = target - nums[i]
            Integer ci = hm.get(target - nums[i]) ;
            if( ci != null){
                int ans[] = { ci , i} ;
                return ans ;
            }
            else{
                hm.put(nums[i] , i ) ;
            }
        }
        int ans[] = {-1 ,-1} ;
        return ans ;
    }
}