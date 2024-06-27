class Solution {
    public int search(int[] nums, int target) {
        int l = 0  ;
        int r = nums.length -1 ;
        while( r >= l ){
            int mid = (l+r)/2 ;
            if( target == nums[mid]){
                return mid ;
            }
            if( nums[r] < nums[l] ){
                if( nums[mid] >= nums[l] ){
                    
                    if(target < nums[mid] && target >= nums[l]){
                        r = mid - 1 ;
                    }
                    else{
                        l = mid + 1 ;
                    }
                }
                else{
                    if(target > nums[mid] && target <= nums[r]){
                        l = mid + 1 ;
                    }
                    else{
                        r = mid - 1 ;
                    }
                }
            }
            else{
                if( target > nums[mid]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
        }

        return -1 ;
    }
}