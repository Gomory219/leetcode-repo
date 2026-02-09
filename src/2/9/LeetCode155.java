import java.util.Deque;
import java.util.LinkedList;

public class LeetCode155 {
    static class MinStack {
        Deque<MyNode> stack;
        Integer minValue = Integer.MAX_VALUE;
        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            this.minValue = Integer.min(minValue, val);
            stack.push(new MyNode(val, this.minValue));
        }

        public void pop() {
            stack.pop();
            if(stack.isEmpty()) {
                minValue = Integer.MAX_VALUE;
            } else {
                minValue = stack.peek().minValue;
            }
        }

        public int top() {
            MyNode top = stack.peek();
            return top.value;
        }

        public int getMin() {
            return this.minValue;
        }

        static class MyNode {
            Integer value;
            Integer minValue;
            public MyNode(Integer value,Integer minValue) {
                this.value = value;
                this.minValue = minValue;
            }
        }
    }
}

/**
 * ["MinStack","push","push","push","getMin","pop","getMin","pop","getMin","pop","push","push","push","getMin","pop","top","getMin","pop","getMin","pop"]
 */