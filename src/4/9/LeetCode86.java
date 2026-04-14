public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode littleDummy = new ListNode();
        
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode littleCur = littleDummy;

        ListNode largerHead = null;

        while (cur != null) {
            if (cur.val < x) {
                littleCur.next = cur;
                littleCur = cur;
                cur = cur.next;
                pre.next = cur;
            } else {
                if (largerHead == null) {
                    largerHead = cur;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        
        littleCur.next = largerHead;
        return littleDummy.next;
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