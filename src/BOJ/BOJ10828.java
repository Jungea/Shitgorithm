package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }

        MyStack stack = new MyStack(n);
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) {
            String[] act = s.split(" ");

            if ("push".equals(act[0])) {
                stack.push(Integer.parseInt(act[1]));
            } else if ("pop".equals(act[0])) {
                sb.append(stack.pop()).append("\n");
            } else if ("top".equals(act[0])) {
                sb.append(stack.top()).append("\n");
            } else if ("size".equals(act[0])) {
                sb.append(stack.size()).append("\n");
            } else if ("empty".equals(act[0])) {
                sb.append(stack.empty()).append("\n");
            }
        }

        System.out.print(sb.toString());

    }

    static class MyStack {

        int[] stack;
        int max;

        int size = 0;
        int front = -1;

        public MyStack(int max) {
            this.max = max;
            this.stack = new int[this.max];
        }

        public void push(int value) {
            this.stack[++this.front] = value;
            this.size++;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            this.size--;
            return this.stack[this.front--];
        }

        public int size() {
            return this.size;
        }

        public int empty() {
            if (size() == 0) {
                return 1;
            }

            return 0;
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            }

            return stack[front];
        }
    }

    static class MyStack2 {

        Deque<Integer> stack = new ArrayDeque<>();

        public MyStack2() {
        }

        public void push(int value) {
            stack.push(value);
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            } else {
                return stack.pop();
            }
        }

        public int size() {
            return stack.size();
        }

        public int empty() {
            if (stack.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            } else {
                return stack.peek();
            }
        }
    }

    static class MyDequeStack {

        private final Deque<Integer> stack = new ArrayDeque<>();

        /**
         * 정수 X를 스택에 넣는 연산이다.
         * @param x
         */
        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            return stack.pop();
        }

        public int size() {
            return stack.size();
        }

        public int empty() {
            return stack.isEmpty() ? 1 : 0;
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            }

            return stack.peek();
        }
    }

    static class MyArrayStack {

        private final int[] stack;
        private int top = -1;


        public MyArrayStack(int n) {
            stack = new int[n];
        }

        /**
         * 정수 X를 스택에 넣는 연산이다.
         * @param x
         */
        public void push(int x) {
            if (top + 1 >= stack.length) {
                return; // 또는 예외 처리
            }

            stack[++top] = x;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            return stack[top--];
        }

        public int size() {
            return top + 1;
        }

        public int empty() {
            return top == -1 ? 1 : 0;
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            }

            return stack[top];
        }
    }
}
