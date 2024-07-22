class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)return true ;

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>(numCourses) ;

        for(int i = 0 ;i<numCourses; i++)adj.add(new ArrayList<>()) ;

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]) ;
        }

        int V = numCourses ;
        Queue<Integer> q = new LinkedList<>() ;
        
        int incoming[] = new int[V] ;
        int ansi = 0 ;
        
        for(int i=0;i<adj.size();i++)for(int j=0;j<adj.get(i).size();j++){
            incoming[ adj.get(i).get(j) ] ++ ;
        }
        
        for(int i =0;i<V;i++)if(incoming[i]==0)q.add(i) ;
        
        while(q.isEmpty() == false){
            int currEle = q.remove() ;
            ansi++ ;
            for(int i = 0 ; i<adj.get(currEle).size();i++){
                // imcoming[adj.get(currEle).get(i)] -- ;
                if(-- incoming[adj.get(currEle).get(i)]==0)q.add(adj.get(currEle).get(i)) ;
            }
        }

        if (ansi == V)return true ;
        return false ; 


    }
}