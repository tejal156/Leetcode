class Trie {


    class TNode{
        TNode childs[] ;
        boolean isEnd ;

        TNode(){
            childs = new TNode[26] ;
            isEnd = false ;
        }
    }

    TNode root ;
    
    // creating a tries
    
    public Trie() {
        root = new TNode() ;   
    }
    
    public void insert(String word) {
        TNode cn = root ; 
        for(int i = 0 ; i < word.length() ; i++){
            char cc = word.charAt(i) ;
            if( cn.childs[cc-'a'] == null)cn.childs[cc-'a'] = new TNode() ;
            cn = cn.childs[cc-'a'] ;
        }
        cn.isEnd = true ; 
    }
    
    public boolean search(String word) {
        TNode cn = root ; 
        for(int i = 0 ; i < word.length() ; i++){
            char cc = word.charAt(i) ;
            if( cn.childs[cc-'a'] == null)return false ;
            cn = cn.childs[cc-'a'] ;
        }
        if(cn.isEnd == true)return true  ;
        return false ;         
    }
    
    public boolean startsWith(String prefix) {
        TNode cn = root ; 
        for(int i = 0 ; i<prefix.length() ; i++){
            char cc = prefix.charAt(i) ;
            if( cn.childs[cc-'a'] == null)return false ;
            cn = cn.childs[cc-'a'] ;
        }
        return true ;           
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */