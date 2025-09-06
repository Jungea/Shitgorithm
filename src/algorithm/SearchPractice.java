package algorithm;

import java.util.*;

public class SearchPractice {
    public static void main(String[] args) {
        int n = 6; // 정점 개수
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());
        graph.put(6, Collections.emptyList());

        boolean[] visited = new boolean[n + 1]; // 1번 노드부터 시작한다고 가정

        bfs(graph, 1, visited); // 1번 정점부터 탐색
    }

    public static void bfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("방문: " + current);

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> graph, int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " "); // 방문 시 출력

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }

    private static void dfsStack(int start, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start); // 시작 정점 스택에 추가
        visited[start] = true;

        while (!stack.isEmpty()) {

            int current = stack.pop();
            System.out.println("방문: " + current);

            // 인접 노드를 스택에 추가
            // 정점 번호가 작은 것부터 먼저 방문하려면 정렬 필요
            List<Integer> neighbors = graph.get(current);
            neighbors.sort(Collections.reverseOrder()); // 작은 정점 먼저 pop되도록 역순 정렬

            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
