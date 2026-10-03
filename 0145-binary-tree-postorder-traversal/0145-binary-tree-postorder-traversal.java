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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }

    void dfs(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        dfs(root.left, result);   // Left
        dfs(root.right, result);  // Right
        result.add(root.val);     // Root
    }
}