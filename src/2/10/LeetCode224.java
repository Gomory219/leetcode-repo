import java.util.Deque;
import java.util.LinkedList;

public class LeetCode224 {
    public static void main(String[] args) {
        String s = "-2147483648";
        Solution solution = new Solution();
        System.out.println(solution.calculate(s));
    }

    static class Solution {
        public int calculate(String s) {
            int ret = 0;
            Deque<Integer> stack = new LinkedList<>();
            s = s.replace(" ", "");
            s = "+(" + s + ")";

            int sign = 1;
            String num = "";
            stack.push(1);

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '+': {
                        if (!num.isEmpty()) {
                            ret += sign * Integer.parseInt(num);
                            num = "";
                        }
                        sign = stack.peek() * 1;
                        break;
                    }
                    case '-': {
                        if (!num.isEmpty()) {
                            ret += sign * Integer.parseInt(num);
                            num = "";
                        }
                        sign = stack.peek() * -1;
                        break;
                    }
                    case '(': {
                        if (!num.isEmpty()) {
                            ret += sign * Integer.parseInt(num);
                            num = "";
                        }
                        stack.push((s.charAt(i - 1) == '-' ? -1 : 1) * stack.peek());
                        break;
                    }
                    case ')': {
                        if (!num.isEmpty()) {
                            ret += sign * Long.parseLong(num);
                            num = "";
                        }
                        stack.pop();
                        break;
                    }
                    default: {
                        num += c;
                        break;
                    }
                }

            }
            if (!num.isEmpty()) {
                ret += sign * Integer.parseInt(num);
                num = "";
            }
            return ret;
        }
    }
}
