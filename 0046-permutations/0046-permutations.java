class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> oldarr = new ArrayList<>() ;
        for(int i = 0 ; i < nums.length ; i++){
            oldarr.add( nums[i]) ;
        }
        helperFun( ans  , oldarr , new ArrayList<>()  ) ;
        return ans ;
    }

    public void helperFun(List<List<Integer>> ans , List<Integer>oldarr , List<Integer>newarr){
        if(oldarr.size() == 0 ){
            // System.out.print(newarr);
            ans.add(new ArrayList<>(newarr) ) ;
            return ;
        }
        for(int i = 0 ; i < oldarr.size() ; i++){
            int temp = oldarr.get(i) ;
            newarr.add(temp) ;
            oldarr.remove(i) ;
            // System.out.print(newarr +" "+oldarr);
            helperFun( ans , oldarr , newarr ) ;
            newarr.remove( newarr.size() -1) ;
            oldarr.add(i,temp);
            // System.out.print(newarr +" "+oldarr);
        }
    }
}