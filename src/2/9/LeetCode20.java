import java.util.Deque;
import java.util.LinkedList;

public class LeetCode20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "{[]}";
        System.out.println(solution.isValid(s));
    }

    static class Solution {
        public boolean isValid(String s) {
            try {
                Deque<Character> deque = new LinkedList<>();
                for (int i = 0; i < s.length(); i++) {
                    switch (s.charAt(i)) {
                        case '(':
                        case '{':
                        case '[':
                            deque.push(s.charAt(i));
                            break;
                        case ')': {
                            Character top = deque.pop();
                            if (top != '(')
                                return false;
                            break;
                        }

                        case '}': {
                            Character top = deque.pop();
                            if (top != '{')
                                return false;
                            break;
                        }

                        case ']': {
                            Character top = deque.pop();
                            if (top != '[')
                                return false;
                            break;
                        }
                    }
                }
                if (!deque.isEmpty()) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
