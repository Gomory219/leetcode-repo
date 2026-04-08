public class LeetCode82 {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head, resultHead = null, preNode = null;
            int curNum = cur.val;
            cur = cur.next;

            while (cur != null) {
                if (cur.val == curNum) {
                    continue;
                }
                curNum = cur.val;
                preNode = cur;
                cur = cur.next;
                resultHead 
                break;
            }

            return null;
        }
    }
}
