import java.util.Arrays;

public class LeetCode112 {
    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 && postorder.length == 0) {
                return null;                
            }
            int curVal = postorder[postorder.length - 1];
            TreeNode curNode = new TreeNode(curVal);

            int inIndex = -1;

            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == curVal) {
                    inIndex = i;
                    break;
                }
            }

            int[] leftInorder = Arrays.copyOfRange(inorder, 0, inIndex);
            int[] leftPostorder = Arrays.copyOfRange(postorder, 0, inIndex);
            
            int[] rightInorder = Arrays.copyOfRange(inorder, inIndex + 1, inorder.length);
            int[] rightPostorder = Arrays.copyOfRange(postorder, inIndex, inorder.length - 1);

            curNode.left = buildTree(leftInorder, leftPostorder);
            curNode.right = buildTree(rightInorder, rightPostorder);

            return curNode;
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