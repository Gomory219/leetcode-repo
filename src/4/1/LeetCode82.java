public class LeetCode82 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = head, cur = null;
            int duplicateVal = 0;

            // 首先需要找到第一个不重复的节点。
            while (pre != null && pre.next != null && pre.val == pre.next.val) {
                while (pre.next != null && pre.val == pre.next.val) {
                    pre = pre.next;
                }
                pre = pre.next;
            }
            head = pre;
            if (head == null) {
                return head;
            }

            cur = pre.next;

            while (cur != null && cur.next != null) {
                if (cur.val != cur.next.val) {
                    pre = cur;
                    cur = cur.next;
                    continue;
                }

                duplicateVal = cur.val;
                while (cur != null && cur.val == duplicateVal) {
                    cur = cur.next;
                }
                pre.next = cur;
            }

            return head;
        }
    }
    class BetterSolution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            
            ListNode pre = dummy, cur = dummy.next;
            while (cur != null && cur.next != null) {
                if (cur.val != cur.next.val) {
                    pre = cur;
                    cur = cur.next;
                    continue;
                }
                int duplicateVal = cur.val;
                while (cur != null && cur.val == duplicateVal) {
                    cur = cur.next;
                }
                pre.next = cur;
            }

            return dummy.next;
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