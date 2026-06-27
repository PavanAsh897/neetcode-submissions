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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        this.res=0;
        class H{
        public int dfs(TreeNode curr){
            if(curr==null) return 0;
        
        int  left=dfs(curr.left);
        int right=dfs(curr.right);
        Solution.this.res=Math.max(res,left+right);
        return 1+ Math.max(dfs(curr.left),dfs(curr.right));
        }
        }
        H h= new H();


        h.dfs(root);
        return res;


        
    }
}
