package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = solution(s, n);

        System.out.println(sum);
    }

    private static int solution(String s, int n) {
        String[] splitString = s.split(" ");
        int[] arr = Arrays.stream(splitString).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int sum = 0;
        int add = 0;
        for (int i = 0; i < n; i++) {
            add += arr[i];
            sum += add;
        }
        return sum;
    }

    private static int solution1(String s, int n) {
        String[] splitString = s.split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(splitString[i]);
        }

        Arrays.sort(arr);

        int sum = 0;
        int add = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] + add);
            add += arr[i];
        }
        return sum;
    }


}
