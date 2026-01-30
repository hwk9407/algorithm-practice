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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();
        stack.offerLast(root);
        depth.offerLast(1);
        int answer = 1;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pollLast();
            Integer currentDepth = depth.pollLast();
            answer = Math.max(answer, currentDepth);
            if (current.left != null) {
                stack.offerLast(current.left);
                depth.offerLast(currentDepth + 1);
            }
            if (current.right != null) {
                stack.offerLast(current.right);
                depth.offerLast(currentDepth + 1);
            }
        }

        return answer;
    }
}