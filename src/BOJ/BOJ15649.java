package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<String> result = new ArrayList<>();
        rec(N, M, new ArrayList<>(), result, new boolean[N + 1]);

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }

    /**
     * @param n       자연수 범위
     * @param m       최대 선택 개수
     * @param order   선택 숫자 목록
     * @param result  결과 목록
     * @param visited 방문여부
     */
    private static void rec(int n, int m, List<Integer> order, List<String> result, boolean[] visited) {
        if (order.size() == m) {
            result.add(joinList(order));
            return;
        }

        // 순열
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(i);
                rec(n, m, order, result, visited);
                order.removeLast();
                visited[i] = false;
            }
        }
    }

    private static String joinList(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
