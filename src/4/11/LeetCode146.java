import java.util.HashMap;
import java.util.Map;




public class LeetCode146 {
    public static void main(String[] args) {
        LeetCode146 leetCode146 = new LeetCode146();;
        LRUCache lruCache = leetCode146.new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.get(4);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(1);
        lruCache.put(5, 5);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(5);
    }

    class LRUCache {

        private int capacity;

        private int size;

        private ListNode head;
        private ListNode end;

        private Map<Integer, ListNode> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            ListNode listNode = map.get(key);
            if (listNode == null) {
                return -1;
            }
            if (listNode.pre != null) {
                if (end == listNode) {
                    end = end.pre;
                }

                listNode.pre.next = listNode.next;
                if (listNode.next != null) {
                    listNode.next.pre = listNode.pre;
                }
                head.pre = listNode;
                listNode.next = head;
                listNode.pre = null;
                head = listNode;

            }

            return listNode.value;
        }

        public void put(int key, int value) {
            int i = get(key);
            if (i != -1) {
                ListNode listNode = map.get(key);
                listNode.value = value;
                return;
            }

            ListNode listNode = new ListNode();
            listNode.value = value;
            listNode.key = key;
            map.put(key, listNode);

            if (head == null) {
                head = listNode;
                end = listNode;
            } else {
                listNode.next = head;
                head.pre = listNode;
                head = listNode;
            }

            size += 1;

            if (size > capacity) {
                map.remove(end.key);
                end = end.pre;
                end.next = null;
                size -= 1;
            }
        }
    }

    class ListNode {
        public ListNode pre;
        public ListNode next;
        public int key;
        public int value;
    }

}

// 3 2 1
// 4 3 2
// 2 3 4
// 5 2 3
// 2 5 3