public class LeetCode226 {

    class Solution {
        private void invert(TreeNode root) {
            if (root == null) {
                return; 
            }
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            invert(root.left);  
            invert(root.right);
        }

        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
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
