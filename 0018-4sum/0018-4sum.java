class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>() ;
        if(nums.length <= 3){
            return ans ;
        }
        Arrays.sort( nums ) ;

        for(int i = 0 ; i < nums.length-3 ; i++){
            for( int j = i+1 ; j < nums.length-2 ; j++ ){
                int s = j+1 ; 
                int e = nums.length -1  ;
                long newtar = (long)target - ( (long)nums[i] + (long)nums[j]) ;

                while( e > s ){
                    if( newtar == ( (long)nums[e]  + (long)nums[s]) ){
                        List<Integer> temp = new ArrayList<>() ;
                        temp.add( nums[i] ) ;
                        temp.add( nums[j] ) ;
                        temp.add( nums[s] ) ;
                        temp.add( nums[e] ) ;
                        ans.add(temp) ;
                        s++ ;
                        while(s < nums.length &&  nums[s] == nums[s-1] ){
                            s++ ;
                        }
                        e-- ;
                        while(   e >= j+1 &&  nums[e] == nums[e+1] ){
                            e-- ;
                        }
                    }
                    else if(newtar >  (long)nums[e]  + (long)nums[s] ){
                        s++ ;
                        while(s < nums.length &&  nums[s] == nums[s-1] ){
                            s++ ;
                        }
                    }
                    else{
                        e-- ;
                        while(   e >= j+1 &&  nums[e] == nums[e+1] ){
                            e-- ;
                        }                       
                    }

                }


                while( j < nums.length-2 && nums[j] == nums[j+1]){
                    j++ ;
                }
            }
            while( (i < nums.length-3 && nums[i] == nums[i+1]) ){
                i++ ;
            }
        }

        return ans ;
    }
}