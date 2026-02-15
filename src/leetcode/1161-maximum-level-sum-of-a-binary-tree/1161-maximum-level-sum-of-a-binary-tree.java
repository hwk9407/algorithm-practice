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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int level = 0;
        int bestLevel = 1;
        int maxSum = -100001;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                sum += current.val;

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                bestLevel = level;
            }
        }

        return bestLevel;
    }
}