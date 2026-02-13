public class LeetCode92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1,2,3,4,5});
        // ListNode listNode = new ListNode(new int[]{1});
        listNode.print();
        Solution solution = new Solution();
        listNode = solution.reverseBetween(listNode, 1, 5);
        // solution.reverseBetween(listNode, 1,1);
        listNode.print();
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode intervalLeft = null, intervalRight = null, begin = null, end = null;
            ListNode cur = head;
            for (int i = 1; i <= (right + 1); i++) {
                if (i == left - 1) {
                    intervalLeft = cur;
                }
                if (i == left) {
                    begin = cur;
                }
                if (i == right + 1) {
                    intervalRight = cur;
                }
                if (i == right) {
                    end = cur;
                }
                cur = cur.next;
                if(cur == null) {
                    break;
                }
            }
            if (intervalLeft != null) {
                intervalLeft.next = end;
            } else {
                head = end;
            }

            cur = begin.next;

            begin.next = intervalRight;

            while (cur != intervalRight) {
                ListNode tmp = cur.next;
                cur.next = begin;
                begin = cur;
                cur = tmp;
            }

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

    ListNode(int[] arr) {
        ListNode cur = this;
        for (int i = 0; i < arr.length; i++) {
            cur.val = arr[i];
            if (i != arr.length - 1) {
                cur.next = new ListNode();
            }
            cur = cur.next;
        }
    }
    public void print() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}