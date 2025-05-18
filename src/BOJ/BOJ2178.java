package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2178 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] i1 = br.readLine().split(" ");
        int[][] maze = new int[Integer.parseInt(i1[0])][Integer.parseInt(i1[1])];

        for (int i = 0; i < maze.length; i++) {
            String[] i2 = br.readLine().split("");
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = Integer.parseInt(i2[j]);
            }
        }

        /*for (int[] m : maze) {
            System.out.println(Arrays.toString(m));
        }*/


        // 우선순위 큐 (행, 열, 거리)
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 1});
        Map<Integer, int[]> result = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (!result.containsKey(cur[0] * 1000 + cur[1])) {
                result.put(cur[0] * 1000 + cur[1], cur);

                findPath(cur[0] + 1, cur[1], cur[2], maze, pq);
                findPath(cur[0] - 1, cur[1], cur[2], maze, pq);
                findPath(cur[0], cur[1] + 1, cur[2], maze, pq);
                findPath(cur[0], cur[1] - 1, cur[2], maze, pq);
            }
        }

        // 마지막 칸의 거리 조회
        if (result.containsKey((maze.length - 1) * 1000 + maze[0].length - 1)) {
            System.out.println(result.get((maze.length - 1) * 1000 + maze[0].length - 1)[2]);
        }
    }

    private static void findPath(int x, int y, int d, int[][] maze, Queue<int[]> pq) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[x].length && maze[x][y] == 1) {
            maze[x][y] = 0;
            pq.add(new int[]{x, y, d + 1});
        }
    }
}
