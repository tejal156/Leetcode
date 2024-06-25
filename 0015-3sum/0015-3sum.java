class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Arrays.sort(nums) ; 
        for(int i =  0 ; i <= nums.length-3 ; i++){

            int s = i+1 ; 
            int e = nums.length-1 ;
            int ntarget = 0 - nums[i] ;
            while(s < e){
                if( nums[s] + nums[e] == ntarget){
                    List<Integer> temp = new ArrayList<>() ;
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    ans.add(temp) ;
                    
                    while( s < e  && nums[s] == nums[s+1]){
                        s++ ;
                    }
                    s++ ;
                    while( e > s  && nums[e] == nums[e-1]){
                        e-- ;
                    }
                    e-- ;             
                }
                else if( nums[s] + nums[e] > ntarget ){
                    while( e > s  && nums[e] == nums[e-1]){
                        e-- ;
                    }                    
                    e-- ;
                }
                else{
                    while( s < e  && nums[s] == nums[s+1]){
                        s++ ;
                    }
                    s++ ;                    
                    
                }
            }

            while(i <= nums.length-3  && nums[i] == nums[i+1] ){
                i++ ;
            }
        }

        return ans ;
    }
}