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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode lastNode = null;
            for (int i = 0; i < size; i++) {
                lastNode = q.poll();
                if (lastNode.left != null) q.offer(lastNode.left);
                if (lastNode.right != null) q.offer(lastNode.right);
            }
            if (lastNode == null) continue;
            result.add(lastNode.val);
        }

        return result;
    }
}