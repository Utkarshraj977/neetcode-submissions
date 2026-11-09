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
    private int maxdia=0;
    public int diameterOfBinaryTree(TreeNode root) {
       maxdia=0;
       diameter(root);
       return maxdia;
    }
    private int diameter(TreeNode root){
        if(root==null) return 0;
        int n1= diameter(root.left);
        int n2= diameter(root.right);
        maxdia=Math.max(maxdia,n1+n2);
        return 1+Math.max(n1,n2);
    }
}
