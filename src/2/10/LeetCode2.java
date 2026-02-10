public class LeetCode2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int n1, n2, reg = 0, val = 0;
            ListNode ret = new ListNode();
            ListNode cur = ret;
            while (true) {
                n1 = l1 == null ? 0 : l1.val;
                n2 = l2 == null ? 0 : l2.val;
                int tmp = n1 + n2 + reg;
                reg = tmp / 10;
                val = tmp % 10;
                cur.val = val;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                if (l1 != null || l2 != null || reg != 0) {
                    cur.next = new ListNode();
                    cur = cur.next;
                } else {
                    break;
                }
            }

            return ret;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}