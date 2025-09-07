package PGS;

public class PGS43162 {
    public int solution(int n, int[][] computers) {

        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, int current, boolean[] visited) {
        visited[current] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(computers, i, visited);
            }
        }
    }
}
