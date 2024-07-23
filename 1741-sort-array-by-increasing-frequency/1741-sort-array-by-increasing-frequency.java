class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length ; 
        int ans[] = new int[n] ;
        int parr[][] = new int[201][2] ;
        int ansi = 0 ; 

        // fill parr
        for(int num : nums){
            parr[num+100][0] = num ; 
            parr[num+100][1] ++ ; 
        }

        // sort
        Arrays.sort( parr , new Comparator<int[]>(){
            public int compare( int[] n1 , int[] n2 ){
                if(n1[1] == n2[1]){
                    return n2[0]-n1[0] ;
                }
                return n1[1] - n2[1] ;
            }
        });

        // fill ans 
        for(int arr[] : parr){
            while(arr[1]-- !=0){
                ans[ansi++] = arr[0] ;
                // arr[1]-- ;
            }
        }

        return ans ; 
    }
}