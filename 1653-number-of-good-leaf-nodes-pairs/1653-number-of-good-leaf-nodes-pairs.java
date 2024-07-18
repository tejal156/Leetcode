/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        int ans[] = new int[1] ;
        helperFun(ans,root,distance) ;
        return ans[0] ;
    }

    public ArrayList<Integer>helperFun(int ans[] ,TreeNode root ,int distance  ){
        if(root == null)return new ArrayList<>() ;
        if(root.left == null && root.right == null){
            ArrayList<Integer>temp = new ArrayList<>() ;
            temp.add(0) ;
            return temp ;
        }
        

        ArrayList<Integer> ll = helperFun(ans, root.left , distance) ;
        ArrayList<Integer> rl = helperFun(ans, root.right , distance) ;
        // if(rl.size() == 0)return ll ; 
        // if(ll.size() == 0)return rl ;

        int il = 0 ; 
        int ir = 0 ;

        while(il<ll.size()  ){
            ir = 0 ;
            while(ir<rl.size()){
                if(ll.get(il) + rl.get(ir)+2 <= distance)ans[0]++ ;
                else break ;
                ir++ ;
            } 
            il ++ ;
        } 

        il = 0 ; ir = 0 ;
        ArrayList<Integer>cl = new ArrayList<>() ;
        while(il<ll.size() && ir<rl.size()){
            if(ll.get(il)+1>= distance && rl.get(ir)+1 >= distance ){
                break ; 
            }
            if(ll.get(il) <= rl.get(ir) && ll.get(il)+1< distance){
                cl.add(ll.get(il)+1) ;
                il++ ;
            }
            else if(rl.get(ir)+1 < distance ){
                cl.add(rl.get(ir)+1) ;
                ir++ ;
            }
            
        }
        while(il<ll.size() ){
            if( ll.get(il)+1 < distance){
                cl.add(ll.get(il)+1) ;
                il++ ;
            }
            else{
                break ; 
            }  
        }    
        while( ir<rl.size()){
            if(rl.get(ir)+1 < distance ){
                cl.add(rl.get(ir)+1) ;
                ir++ ;
            }
            else{
                break ; 
            }
            
        } 
        // System.out.println("root val : "+root.val +" ans: "+ans[0]+" cl: "+cl) ;  
        return cl ;
    }
}