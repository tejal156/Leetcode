class Solution {
    public boolean isBipartite(int[][] graph) {
        int nv = graph.length ;
        int clr[] = new int[nv] ;
        Queue<Integer> q = new LinkedList<>() ;
    
        for(int j = 0 ; j < nv ; j++){
            if( clr[j] == 0 ){
                q.add(j) ;
                clr[j] = 1 ; 
                while(q.isEmpty() == false){
                    int currv = q.remove() ;

                    for(int i = 0 ; i < graph[currv].length ; i++ ){
                        if(clr[graph[currv][i]] == 0){
                            clr[graph[currv][i]] = (clr[currv] == 1? 2:1  ) ;
                            q.add( graph[currv][i]  ) ;
                        }
                        else{
                            if( clr[graph[currv][i]] == clr[currv] )return false ; 
                        }
                    }
                }



            }
        }

        return true ;
    }
}