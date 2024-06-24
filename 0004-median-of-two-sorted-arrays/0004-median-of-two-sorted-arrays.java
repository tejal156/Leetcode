class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int space = (nums1.length + nums2.length) / 2;
        int l = 0;
        int r = Math.min(nums1.length, nums2.length);
        int is, ib;
        int space = (nums1.length + nums2.length+1) / 2;
        if( nums1.length > nums2.length) return findMedianSortedArrays( nums2, nums1 ) ;
        int n1 = nums1.length ;
        int n2 = nums2.length ;
        int l1 =0 , l2 =0 , r1 =0 , r2 =0 ;
        while (r >= l) {
            int mid = (l + r) / 2;
            int i1 , i2 ;
            i1 = mid;
            i2 = space - i1;
            
            l2 = Integer.MIN_VALUE ;
            l1 = Integer.MIN_VALUE ;
            r1 = Integer.MAX_VALUE ;
            r2 = Integer.MAX_VALUE ;
            if( i1 < n1) r1 = nums1[i1] ;
            if( i2 < n2) r2 = nums2[i2] ;
            if( i1-1 >= 0 ) l1 = nums1[i1-1] ;
            if( i2-1 >= 0 ) l2 = nums2[i2-1] ;
            if( l1 <= r2 &&  l2 <= r1){
                break ;
            }
            if(l1 > r2){
                r = mid -1 ;
            }
            else{ l = mid + 1 ;} ;


        }

            double t1 = (double)Math.max(l1 , l2) ;
            double t2 = (double)Math.min(r1 , r2) ;
        if( (n1+n2) %2 == 0){

            return (t1+t2)/2 ;
        }
        else{
            // take min of next one
            return t1 ;
        }

    }
}