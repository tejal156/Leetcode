class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // initialization
        int arr[][] = new int[nums.length][2] ;
        int ans[] = new int[nums.length] ;

        // fill arr [new value ][index]
        for(int i = 0 ; i < arr.length ; i++){
            convert( arr[i] , i ,mapping , nums[i] ) ;
        }

        // sort arr
        Arrays.sort(arr , new Comparator<int[]>(){
            public int compare( int a1[] , int a2[]){
                if( a1[0] == a2[0]) return a1[1] - a2[1] ;
                return a1[0] - a2[0] ;
            }
        }) ;

        // fill ans 
        for(int i = 0 ; i < arr.length ; i++){
            ans[i] = nums[arr[i][1] ] ;
        }  

        return ans  ;       
    }

    public void convert(int arr[] , int index , int[] mapping , int num ){

        int newnum = 0 ; 
        ArrayList<Integer> al = new ArrayList<>() ;

        // fill 1th index
        arr[1] = index ; 

        // fill al 
        if (num == 0 )al.add( mapping[ num%10] ) ; 
        while(num != 0 ){
            al.add( mapping[ num%10] ) ;
            num /= 10 ; 
        }

        // fill 0 th index
        int currnum = 0 ; 
        for(int i = al.size()-1 ; i >= 0 ; i--){
            currnum *= 10 ; 
            currnum += al.get(i) ;
        }

        arr[0] = currnum ; 
    }
}