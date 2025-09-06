package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            g.get(a).add(b);
            g.get(b).add(a);
        }

        int result = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                bfs(g, i, visited);
//                dfs(g, i, visited);
            }
        }

        System.out.println(result);
    }

    private static void dfs(List<List<Integer>> g, int i, boolean[] visited) {
        visited[i] = true;

        for (Integer v : g.get(i)) {
            if (!visited[v]) {
                dfs(g, v, visited);
            }
        }
    }

    private static void bfs(List<List<Integer>> g, int i, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int key = q.poll();

            for (Integer v : g.get(key)) {
                if (!visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
    }
}
