
public class LeetCode104 {

    class Solution {

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(dfs(root.left) + 1, dfs(root.right) + 1) ;
        }

        public int maxDepth(TreeNode root) {
            return dfs(root);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
