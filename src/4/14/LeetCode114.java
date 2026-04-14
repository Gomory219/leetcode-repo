public class LeetCode114 {
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                flatten(left);  
            }
            if (right != null) {
                flatten(right); 
            }
            root.right = left;

            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
            root.left = null;
        }
    }

    public class TreeNode {
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
