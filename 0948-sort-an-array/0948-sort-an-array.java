class Solution {
    public int[] sortArray(int[] nums) {
        int index = 0 ;
        int ans[] = new int[nums.length] ;
        for(int num : nums)ans[index++]= num ;
        divideFun( ans , 0 , nums.length -1 ) ;
        return ans ; 
    }

    public void divideFun(int[] nums , int s , int e){
        if(s >= e)return ; 
        int mid = s + (e-s)/2 ; 
        divideFun(nums , s , mid) ;
        divideFun(nums , mid+1 , e) ;
        mergeFun(nums , s , e , mid) ;

    }

    public void mergeFun( int[] nums , int s , int e , int mid ){
        if(s == e )return ; 
        int i = s ; 
        int j = mid+1 ; 
        int ans[] = new int[e-s+1] ;
        int index = 0 ;
        // System.out.println( s+" "+e+" "+mid+" "+ans.length) ;

        while(i <= mid && j <= e){
            if(nums[i] >= nums[j]){
                ans[index++] = nums[j++] ;
            }
            else{
                ans[index++] = nums[i++] ;
            }
        } 
        while(i <= mid ){
            ans[index++] = nums[i++] ;
        } 
         
        while(j <= e ){
            ans[index++] = nums[j++] ;
        } 

        index = s ; 
        for(int num : ans)nums[index++] = num ;
        return ;  
    }
}