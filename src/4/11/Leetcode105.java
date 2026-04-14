import java.util.Arrays;


public class Leetcode105 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        arr = Arrays.copyOfRange(arr, 3, 3);
        System.out.println(Arrays.toString(arr));
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            int val = preorder[0];
            TreeNode treeNode = new TreeNode(val);
            int middleIndex = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == val) {
                    middleIndex = i;
                }
            }
            int[] leftInorder = Arrays.copyOfRange(inorder, 0,middleIndex);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + middleIndex);
            
            int[] rightInorder = Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length);
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + middleIndex, preorder.length);

            treeNode.left = buildTree(leftPreorder, leftInorder);
            treeNode.right = buildTree(rightPreorder, rightInorder);
            
            return treeNode;
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
