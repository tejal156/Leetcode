class Solution {
    public double myPow(double x, int n) {
        long tn = n ;
        double x1= x ;
        if(n < 0 ) tn = -1 * tn ;
        double ans = 1.0 ;
        while(tn > 0){
            if( tn % 2 == 0 ){
                x1 = x1 * x1 ;
                tn = tn / 2 ;
            }
            else{
                ans *= x1 ;
                tn = tn-1 ;
            }
        }
        if(n < 0 ) ans = (double)1.0/ (double)ans;
        return ans ;
    }
}