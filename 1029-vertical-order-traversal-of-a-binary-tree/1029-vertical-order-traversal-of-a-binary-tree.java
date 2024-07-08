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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> arr = new ArrayList<>() ;
        visitAllNodes( root , 0 , 0 , arr) ;
        Collections.sort( arr , new Comparator<int[]>(){
            public int compare( int arr1[] , int arr2[] ){
                if( arr1[1] != arr2[1] ){
                    return arr1[1] - arr2[1] ;
                }
                if( arr1[2] != arr2[2] ){
                    return arr1[2] - arr2[2] ;
                }
                return arr1[0] - arr2[0] ;
            }
        }) ;

        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer>subarr =new ArrayList<>() ; 
        for(int i = 0 ; i < arr.size() ; i++ ){
            if(i == 0){
                subarr = new ArrayList<>() ; 
                subarr.add( arr.get(i)[0] ) ;
            }
            else if(arr.get(i)[1] != arr.get(i-1)[1]){
                ans.add( subarr ) ;
                subarr = new ArrayList<>() ; 
                subarr.add( arr.get(i)[0] ) ;
            }
            else{
                subarr.add( arr.get(i)[0] ) ;
            }

            if(i == arr.size()-1 ){
                ans.add( subarr ) ;
            }
            // System.out.println( arr.get(i)[0] +" "+ arr.get(i)[1] +" "+ arr.get(i)[2]  + " : "+subarr) ;

        }


        return ans ; 
    }

    
    public void visitAllNodes(TreeNode root , int p , int l , List<int[]> arr){
        if( root == null ){
            return ; 
        }
        int temp[] = { root.val , p , l} ;
        arr.add(temp) ;
        visitAllNodes( root.left , p-1 , l+1 , arr) ;
        visitAllNodes( root.right , p+1 , l+1 , arr);

    }
}