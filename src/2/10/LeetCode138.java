import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode138 {

    /*
     * // Definition for a Node.
     * class Node {
     * int val;
     * Node next;
     * Node random;
     * 
     * public Node(int val) {
     * this.val = val;
     * this.next = null;
     * this.random = null;
     * }
     * }
     */
    static class Solution {
        public Node copyRandomList(Node head) {
            List<Node> srcList = new ArrayList<>();
            List<Node> tarList = new ArrayList<>();
            Map<Node, Integer> srcMap = new HashMap<>();
            int index = 0;
            while (head != null) {
                srcList.add(head);
                srcMap.put(head, index);
                index++;
                head = head.next;
            }
            for (int i = 0; i < srcList.size(); i++) {
                tarList.add(new Node(srcList.get(i).val));
            }
            for (int i = 0; i < srcList.size(); i++) {
                tarList.get(i).next = (i == srcList.size() - 1 ? null : tarList.get(i + 1));
                tarList.get(i).random = (srcMap.get(srcList.get(i).random) == null) ? null
                        : tarList.get(srcMap.get(srcList.get(i).random));
            }
            if (tarList.size() == 0) {
                return null;
            }
            return tarList.get(0);
        }
    }

    static class BetterSolution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            for (Node cur = head; cur != null; cur = cur.next) {
                map.put(cur, new Node(cur.val));

            }
            for (Node cur = head; cur != null; cur = cur.next) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
            }
            return map.get(head);
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}