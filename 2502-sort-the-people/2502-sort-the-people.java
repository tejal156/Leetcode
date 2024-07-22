class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer , String> hm = new HashMap<>() ;

        for(int i = 0 ; i < names.length ; i++)hm.put( heights[i] , names[i]) ;

        Arrays.sort( heights ) ;

        String ans[] = new String[ names.length ] ;
        for(int i = names.length -1 ; i>= 0 ;i--)ans[names.length-i-1] =hm.get( heights[i]) ;

        return ans ;  
    }
}