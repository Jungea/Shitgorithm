package PGS;

import java.util.Set;
import java.util.TreeSet;

public class PGS42862 {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];

        for (int l : lost) {
            clothes[l]--;
        }

        for (int r : reserve) {
            clothes[r]++;
        }

        for (int i = 1; i < clothes.length; i++) {
            if (clothes[i] == 1) {
                if (clothes[i - 1] == -1) {
                    clothes[i] = 0;
                    clothes[i - 1] = 0;
                } else if (clothes[i + 1] == -1) {
                    clothes[i] = 0;
                    clothes[i + 1] = 0;
                }
            }
        }

        int answer = 0;
        for (int c : clothes) {
            if (c > -1) {
                answer++;
            }
        }

        return answer - 2;
    }

    public int solution2(int n, int[] lost, int[] reserve) {

        Set<Integer> plus = new TreeSet<>();
        for (int i : reserve) {
            plus.add(i);
        }

        Set<Integer> minus = new TreeSet<>();
        for (int i : lost) {

            // 여분이 있는 학생 중 도난당한 학생 제외
            if (plus.contains(i)) {
                plus.remove(i);

            } else {
                minus.add(i);
            }
        }

        int finLost = 0;  // 최종 체육복 없는 사람수
        for (Integer m : minus) {
            if (m > 1 && plus.contains(m - 1)) {
                plus.remove(m - 1);
            } else if (m < n && plus.contains(m + 1)) {
                plus.remove(m + 1);
            } else {
                finLost++;
            }
        }

        return n - finLost;
    }
}
