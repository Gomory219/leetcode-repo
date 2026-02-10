public class LeetCode141 {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fastPointer = head;
            ListNode pointer = head;

            if(head == null || head.next == null) {
                return false;
            }

            while (true) {
                pointer = pointer.next;
                fastPointer = fastPointer.next;

                if (fastPointer == null || fastPointer.next == null) {
                    return false;
                } else {
                    fastPointer = fastPointer.next;
                }

                if (pointer == fastPointer) {
                    return true;
                }

            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}