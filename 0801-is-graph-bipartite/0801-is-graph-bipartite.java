class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[ graph.length ] ;
        for(int i = 0 ; i < color.length ; i++){
            if(color[i] == 0){
                if( dfs( graph , color , i )  == false) return false ; 
            }
        }
        return  true ;
    }

    public boolean dfs( int[][] graph , int color[] , int curri ){
        for(int i = 0 ; i < graph[curri].length ; i++ ){
            int ni = graph[curri][i] ; 
            if( color[ni] == 0 ){
                color[ni] = ( color[curri] == 1? 2 :1);
                if( dfs(graph , color , ni)  == false)return false ; 
            }
            else{
                if( color[ni] == color[curri] )return false ; 
            }
        }
        return true ; 
    }
}