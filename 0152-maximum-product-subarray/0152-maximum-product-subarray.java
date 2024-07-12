class Solution {
    public int maxProduct(int[] nums) {
        double max = (double)Long.MIN_VALUE ;
        double currmul = 1l ;
        for(int ele : nums) max = Math.max(max ,  currmul = ((currmul==0l)? (double)1: currmul)*(double)ele ) ;
            
    
        currmul = 1l ; 
        for(int i=nums.length-1;i>= 0;i--)max = Math.max(max , currmul = ((currmul==0)?(double)1:currmul)*(double)nums[i] ) ;
        return (int)max ; 
    }
}