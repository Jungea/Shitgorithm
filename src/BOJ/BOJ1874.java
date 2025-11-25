package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1874 {

    /*
     * 첫째줄 N
     * 1~N 까지 중복없는 숫자가 주어짐.
     * 압력으로 POP 으로 완셩되는 수열 요구사항
     *
     * 오름차순으로 PUSH 조건을 만족하면서 POP 수열 요구사항을 만족하게 POP 가능한가?
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
//        int[] want = new int[n + 1];
//        for (int i = 1; i < want.length; i++) {
//            want[i] = Integer.parseInt(br.readLine());
//        }

        int[] want = new int[]{0, 4, 3, 6, 8, 7, 5, 2, 1};
//        int[] want = new int[]{0, 1,2,5,3,4};

        System.out.println(solution(want));
    }

    /**
     * 정답
     * @param want
     * @return
     */
    public static String solution(int[] want) {
        int n = want.length - 1;
        int wantIndex = 1;
        int number = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        stack.push(number++);
        sb.append("+").append("\n");

        while (wantIndex <= n) {

            // 원하는 값까지 PUSH
            while (number <= want[wantIndex]) {
                stack.push(number++);
                sb.append("+").append("\n");
            }

            if (stack.isEmpty() || stack.peek() != want[wantIndex]) {
                return "NO";
            }

            stack.pop();
            sb.append("-").append("\n");
            wantIndex++;
        }

        return sb.toString();
    }


    /**
     * 나의 정답
     * @param want
     * @return
     */
    public static String solution1(int[] want) {
        int n = want.length - 1;
        int wantIndex = 1;
        int number = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty() || number <= n) {

            if (!stack.isEmpty() && stack.peek() == want[wantIndex]) {
                stack.pop();
                sb.append("-").append("\n");
                wantIndex++;

            } else if (number <= n) {
                stack.push(number++);
                sb.append("+").append("\n");

            } else {
                return "NO";
            }
        }

        return sb.toString();
    }

}
