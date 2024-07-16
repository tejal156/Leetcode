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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder currPath = new StringBuilder() ;
        ArrayList<String> ans = new ArrayList<>();
        findPath( currPath,ans,root,startValue) ;
        currPath = new StringBuilder() ;
        findPath( currPath,ans,root,destValue) ;
        String sp = ans.get(0) ;
        String  ep = ans.get(1) ;
        // System.out.println(sp+" "+ep) ;
        int si =0, ei =0 ; 
        while(si <sp.length() && ei<ep.length()){

            if( sp.charAt(si) != ep.charAt(ei)) break ; 
            si++;ei++ ;

        }
        
        StringBuilder ansL = new StringBuilder("") ;
        for(int i = si ; i< sp.length();i++)ansL.append("U");
        for(int i = ei ; i<ep.length();i++)ansL.append(ep.charAt(i));
        return ansL.toString() ;

    }

    public boolean findPath( StringBuilder currPath , ArrayList<String> ans ,TreeNode root,int target ){
        if(root == null)return false ;
        if(root.val == target ){
            ans.add(currPath.toString()) ;
            return true ; 
        }
        if( findPath(currPath.append("L"),ans,root.left,target ) )return true ;
        currPath.deleteCharAt( currPath.length()-1) ;
        if( findPath(currPath.append("R"),ans,root.right,target ) )return true ;
        currPath.deleteCharAt( currPath.length()-1) ;
        return false ; 
    }
}