package PGS;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGS42587 {
    /*
     * 1. 대기큐에서 poll
     * 2. 우선순위가 더 높은 프로세스가 있다면 대기큐에 offer
     * 3. 아니라면 제외
     */

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Process> q = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            Process p = new Process(i, priorities[i]);
            q.offer(p);

            pq.offer(priorities[i]);
        }

        while (!pq.isEmpty()) {
            int first = pq.peek();

            Process p = q.poll();
            if (p.getImportance() < first) {
                q.offer(p);
            } else {
                answer++;
                pq.poll();

                if (location == p.getId()) {
                    return answer;
                }
            }
        }

        return answer;
    }

    static class Process {

        private final int id;
        private final int importance;

        public Process(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }

        public int getId() {
            return id;
        }

        public int getImportance() {
            return importance;
        }
    }
}
