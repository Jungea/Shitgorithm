package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        MyDequeQueue myQueue = new MyDequeQueue();
        MyArrayQueue myQueue = new MyArrayQueue(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");

            switch (tmp[0]) {
                case "push":
                    myQueue.push(Integer.parseInt(tmp[1]));
                    break;
                case "pop":
                    sb.append(myQueue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(myQueue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(myQueue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(myQueue.front()).append("\n");
                    break;
                case "back":
                    sb.append(myQueue.back()).append("\n");
                    break;
            }

        }

        System.out.println(sb.toString());

        br.close();
    }

    /**
     * Deque로 Queue 구현
     */
    static class MyDequeQueue {

        private final Deque<Integer> queue = new ArrayDeque<>();

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

    /**
     * Array로 Queue 구현
     */
    static class MyArrayQueue {

        private final int[] queue;
        private final int capacity;

        private int size;
        private int front = 0;
        private int rear = -1;

        public MyArrayQueue(int n) {
            this.queue = new int[n];
            this.capacity = n;
        }

        public void push(int x) {
            rear = (rear + 1 + capacity) % capacity;
            queue[rear] = x;
            size++;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            int x = queue[front];
            front = (front + 1 + capacity) % capacity;
            size--;

            return x;
        }

        public int size() {
            return this.size;
        }

        public int empty() {
            return this.size == 0 ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }

            return queue[front];
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }

            return queue[rear];
        }
    }
}
