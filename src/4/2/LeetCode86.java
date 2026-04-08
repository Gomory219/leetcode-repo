public class LeetCode86 {
    class Solution {
        /*
        [1,1] x:2
        []
        [1,4,3,2,5,2] x:3
         */
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur = head, headLast = dummy ,pre = dummy;
            while (cur != null) {
                if (cur.val < x) {
                    ListNode t = cur.next;
                    pre.next = cur.next;
                    cur.next = headLast.next;
                    headLast.next = cur;
                    headLast = cur;
                    cur = t;
                } else {
                    pre = cur;
                    cur = cur.next;
                }                
            }
            return head;
        }
    }

    public class ListNode {
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
}
