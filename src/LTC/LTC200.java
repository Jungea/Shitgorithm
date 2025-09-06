package LTC;

import java.util.ArrayDeque;
import java.util.Queue;

public class LTC200 {

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {  // 육지를 찾아
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {

        // 그래프 범위를 벗어나거나 물일 경우 탐색 종료
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';  // 육지 방문 처리

        // 동서남북 탐색
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }

    public void bfs(char[][] grid, int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{startX, startY});
        grid[startX][startY] = '0';

        while (!q.isEmpty()) {
            int[] value = q.poll();
            int x = value[0];
            int y = value[1];

            final int[][] DIRECTION = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] d : DIRECTION) {
                int dx = x + d[0];
                int dy = y + d[1];

                if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == '1') {
                    grid[dx][dy] = '0';
                    q.offer(new int[]{dx, dy});
                }
            }
        }
    }
}
