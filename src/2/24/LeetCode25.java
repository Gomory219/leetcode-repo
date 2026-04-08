public class LeetCode25 {

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode resultLast = head, curFirst = head, toModify = head.next;
            ListNode cur = head;
            int length = 0;

            for (length = 0; cur != null; length++, cur = cur.next)
                ;

            if (length < k) {
                return head;
            }

            for (int i = 0; i < k - 1; i++) {
                ListNode tmp = toModify.next;
                toModify.next = curFirst;
                curFirst = toModify;
                toModify = tmp;
            }
            resultLast.next = reverseKGroup(toModify, k);
            resultLast = toModify;
            head = curFirst;

            return head;
        }
    }
}

