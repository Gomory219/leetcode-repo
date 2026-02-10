public class LeetCode21 {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode ret = new ListNode();
            ListNode cur = ret;

            while (list1 != null && list2 != null) {
                int val = 0;

                if (list1.val < list2.val) {
                    val = list1.val;
                    list1 = list1.next;
                } else {
                    val = list2.val;
                    list2 = list2.next;
                }

                cur.next = new ListNode();
                cur = cur.next;
                cur.val = val;
            }

            while (list1 != null) {
                cur.next = new ListNode();
                cur = cur.next;
                cur.val = list1.val;
                list1 = list1.next;
            }

            while (list2 != null) {
                cur.next = new ListNode();
                cur = cur.next;
                cur.val = list2.val;
                list2 = list2.next;
            }

            return ret.next;
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