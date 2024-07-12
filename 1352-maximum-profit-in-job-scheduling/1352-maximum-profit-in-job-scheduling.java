class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length ; 
        int arr[][] = new int[n][3] ;
        int dp[] = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
            dp[i] = -1 ;
        }
        
        
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare( int num1[] , int num2[] ){
                return num1[0]-num2[0] ; 
            }
        });

        return helperFun(arr,0,dp) ;
    }

    int helperFun( int arr[][] , int ci , int dp[]){
        int n = arr.length ;
        if(ci == n )return 0 ;
        if(dp[ci]!=-1)return dp[ci]; 
        int max = 0 ;
        // add in profit 
        int next =findNext(arr,ci,n-1,arr[ci][1]);
        max =  Math.max(max , helperFun(arr,next,dp)+arr[ci][2] ) ;

        // do not add in profit
        max = Math.max(max , helperFun(arr,ci+1,dp) ) ;
        // int next = findNext(arr,ci,n-1,arr[ci][1]);
        // System.out.println(ci+" "+max+" next"+next);
        dp[ci] = max ;
        return max ; 
    }

    int findNext(int arr[][] , int si , int ei , int target ){
        while(si <= ei){
            int mid = si + (ei-si)/2 ;           
            if( target > arr[mid][0] )si = mid+1 ;
            else ei = mid-1 ; 
        }
        return si ; 
    }
}