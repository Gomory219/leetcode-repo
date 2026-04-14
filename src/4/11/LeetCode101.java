public class LeetCode101 {

    /*
        2 
    3        3
4      5   5     4
    8   9 9  8  


    */
    class Solution {
        private void reverse(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            reverse(root.left);
            reverse(root.right);
        }

        private boolean isSame(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }

        public boolean isSymmetric(TreeNode root) {
            reverse(root.right);
            return isSame(root.left, root.right);
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
