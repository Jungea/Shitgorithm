package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String roomNum = br.readLine();

        int[] count = new int[10];
        for (char c : roomNum.toCharArray()) {
            count[c - '0']++;
        }

        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }

            if (count[i] > max) {
                max = count[i];
            }
        }

        int specialCount = (count[6] + count[9] + 1) / 2; // 올림
//        int specialCount = (count[6] + count[9]) / 2;
//        specialCount += (count[6] + count[9]) % 2;

        System.out.println(Math.max(max, specialCount));
    }
}
