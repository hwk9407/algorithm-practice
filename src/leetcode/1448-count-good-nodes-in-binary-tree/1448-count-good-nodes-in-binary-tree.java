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
    public int goodNodes(TreeNode root) {
        return dfs(root, -10000);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;

        max = Math.max(max, node.val);
        int count = 0;
        if (node.val >= max) count = 1;
        count += dfs(node.left, max);
        count += dfs(node.right, max);

        return count;
    }
}