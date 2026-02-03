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
    private int max;
    public int longestZigZag(TreeNode root) {
        this.max = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return max;
    }

    private void dfs(TreeNode node, boolean direction, int current) {
        if (node == null) return;

        this.max = Math.max(this.max, current);
        if (!direction) {
            dfs(node.left, false, 1);
            dfs(node.right, true, current + 1);
        } else {
            dfs(node.right, true, 1);
            dfs(node.left, false, current + 1);
        }
    }
}