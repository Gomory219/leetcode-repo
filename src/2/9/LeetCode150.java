import java.util.Deque;
import java.util.LinkedList;

public class LeetCode150 {
    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for (String token : tokens) {
                if (isNumber(token)) {
                    int num = Integer.parseInt(token);
                    stack.push(num);
                } else {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(calculate(n2, n1, token));
                }
            }
            return stack.peek();
        }

        public boolean isNumber(String token) {
            return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
        }

        private int calculate(int n1, int n2, String op) {
            switch (op) {
                case "+": {
                    return n1 + n2;
                }
                case "-": {
                    return n1 - n2;
                }
                case "*": {
                    return n1 * n2;
                }
                case "/": {
                    return n1 / n2;
                }
                default: {
                    return 1;
                }
            }
        }
    }

}
