package PGS;

public class PGS43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        return rec(numbers, target, 0);
    }

    private static int rec(int[] numbers, int target, int i) {
        if (i == numbers.length && target == 0) {
            return 1;
        }

        if (i >= numbers.length) {
            return 0;
        }

        return rec(numbers, target - numbers[i], i + 1) + rec(numbers, target + numbers[i], i + 1);
    }
}
