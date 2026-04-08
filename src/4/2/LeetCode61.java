import java.util.HashMap;
import java.util.Map;

public class LeetCode61 {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            Map<Integer, ListNode> map = new HashMap<>();
            ListNode cur = head;
            int cnt = 0;

            while (cur != null) {
                map.put(cnt, cur);
                
                cur = cur.next;
                cnt++;
            }
            k %= cnt;
            if (cnt == 0) {
                return head;
            }
            
            int lastIndex = cnt - k - 1;

            map.get(cnt - 1).next = head;
            map.get(lastIndex).next = null;

            return map.get((lastIndex + 1)%cnt);
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
