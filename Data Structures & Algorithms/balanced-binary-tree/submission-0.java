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
    private boolean m=true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return m;
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int h1=height(root.left);
        int h2=height(root.right);
        if(Math.abs(h2-h1)>1) m=false;
        return 1+Math.max(h1,h2);
    }
}
