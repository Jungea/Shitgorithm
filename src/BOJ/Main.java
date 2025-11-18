package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        MyDequeQueue myStack = new MyDequeQueue();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");

            switch (tmp[0]) {
                case "push":
                    myStack.push(Integer.parseInt(tmp[1]));
                    break;
                case "pop":
                    sb.append(myStack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(myStack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(myStack.empty()).append("\n");
                    break;
                case "front":
                    sb.append(myStack.front()).append("\n");
                    break;
                case "back":
                    sb.append(myStack.back()).append("\n");
                    break;
            }

        }

        System.out.println(sb.toString());

        br.close();
    }

    static class MyDequeQueue {

        private final Deque<Integer> queue = new ArrayDeque<>();

        /**
         * 정수 X를 스택에 넣는 연산이다.
         * @param x
         */
        public void push(int x) {
            queue.offerLast(x);
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            return queue.pollFirst();
        }

        public int size() {
            return queue.size();
        }

        public int empty() {
            return queue.isEmpty() ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }

            return queue.peekFirst();
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }

            return queue.peekLast();
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
