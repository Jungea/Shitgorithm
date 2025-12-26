package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/**
 * 1920. 수 찾기
 * A 목록안에 B 목록의 수들이 존재하는지 여부
 * 존재확인 = Hash
 */
public class BOJ1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(set.contains(x) ? "1" : "0").append("\n");
        }

        System.out.print(sb.toString());
    }

    public void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] as = br.readLine().split(" ");

        Set<String> set = new HashSet<>(Arrays.asList(as));

        int m = Integer.parseInt(br.readLine());
        String[] bs = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String b : bs) {
            sb.append(set.contains(b) ? "1" : "0").append("\n");
        }

        System.out.println(sb.toString());
    }

}
