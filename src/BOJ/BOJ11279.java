package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11279 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append("0").append("\n");

                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
