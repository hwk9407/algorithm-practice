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
    private static int targetSum;
    private static int answer;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        this.targetSum = targetSum;
        answer = 0;
        dfs(root, 0, sumCount);

        return answer;
    }

    private void dfs(TreeNode node, int sum, Map<Integer, Integer> sumCount) {
        if (node == null) return;
        int current = node.val + sum;
        answer += sumCount.getOrDefault(current - targetSum, 0);
        sumCount.merge(current, 1, Integer::sum);
        dfs(node.left, current, sumCount);
        dfs(node.right, current, sumCount);
        sumCount.merge(current, -1, Integer::sum);
    }
}