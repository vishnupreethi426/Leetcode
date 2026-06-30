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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> s = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root,path,s);
        return s;
    }
    public void dfs(TreeNode root,StringBuilder path,List<String> s){

   
        if(root == null) {
            return ;
        }
        int len = path.length();
        path.append(root.val);
        if(root.left==null && root.right==null){
            s.add(path.toString());
        }
        else{
            path.append("->");

            dfs(root.left,path,s);
            dfs(root.right,path,s);
        }

        
        path.setLength(len);
    }
}