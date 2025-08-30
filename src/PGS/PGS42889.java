package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS42889 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    static class Stage implements Comparable<Stage> {
        int no;
        int tryCount;
        int totalCount;

        public Stage(int no, int tryCount, int totalCount) {
            this.no = no;
            this.tryCount = tryCount;
            this.totalCount = totalCount;
        }

        public float getPercent() {
            return tryCount == 0 ? 0 : (float) tryCount / totalCount;
        }

        @Override
        public int compareTo(Stage o) {
            return this.getPercent() == o.getPercent() ?
                    this.no - o.no : Float.compare(o.getPercent(), this.getPercent());
        }
    }

    public static int[] solution(int N, int[] stages) {

        // 도달 스테이지 카운트
        int[] count = new int[N + 2];
        int totalCount = 0;
        for (int stage : stages) {
            count[stage]++;
            totalCount++;
        }
        System.out.println(Arrays.toString(count));

        List<Stage> list = new ArrayList<>(); // stage, 실패율
        for (int i = 1; i < N + 1; i++) {
            list.add(new Stage(i, count[i], totalCount));
            totalCount -= count[i];
        }

        list.sort(null);

        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).no;
        }

        return answer;
    }
}
