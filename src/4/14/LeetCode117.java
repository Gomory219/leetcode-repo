import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<NodeWithDepth> queue = new LinkedList<>();
            queue.add(new NodeWithDepth(root, 1));
            NodeWithDepth curNode = null;
            NodeWithDepth lastNode = null;
            while ((curNode = queue.poll()) != null) {
                Node node = curNode.node;
                Integer depth = curNode.depth;
                if (node.left != null) {
                    queue.add(new NodeWithDepth(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.add(new NodeWithDepth(node.right, depth + 1));
                }
                if (lastNode != null && lastNode.depth == curNode.depth) {
                    lastNode.node.next = curNode.node;
                }
                lastNode = curNode;
            }

            return root;
        }
    }

    class NodeWithDepth {
        Node node;
        Integer depth;

        public NodeWithDepth(Node node, Integer depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
