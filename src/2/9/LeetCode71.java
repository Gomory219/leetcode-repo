import java.util.Deque;
import java.util.LinkedList;

public class LeetCode71 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/.../a/../b/c/../d/./";
        System.out.println(solution.simplifyPath(path));
    }

    static class Solution {
        public String simplifyPath(String path) {
            String result = "";
            String[] splits = path.split("/");
            Deque<String> deque = new LinkedList<>();
            // System.out.println(Arrays.toString(split));
            for (int i = 0; i < splits.length; i++) {
                String split = splits[i];
                if (split.equals("") || split.equals(".")) {
                    continue;
                } else if (split.equals("..")) {
                    if (deque.isEmpty()) {
                        continue;
                    }
                    deque.removeLast();
                } else {
                    deque.addLast(split);
                }
            }
            result = String.join("/", deque);
            return "/" + result;
        }
    }
}
