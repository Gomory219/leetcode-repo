public class LeetCode19 {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode target = head, pre = null, cur = head;
            int len = 0;
            while (cur != null) {
                len++;
                cur = cur.next;
            }
            for (int i = 1; i <= len - n; i++) {
                if (i == len - n) {
                    pre = target;
                }
                target = target.next;
            }
            if (pre == null) {
                head = head.next;
                return head;
            }
            pre.next = target.next;
            return head;
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