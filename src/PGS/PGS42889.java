package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PGS42889 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public static class StageInfo implements Comparable<StageInfo> {
        int no;
        int tryCount;
        int finishCount;

        public StageInfo(int no, int tryCount, int finishCount) {
            this.no = no;
            this.tryCount = tryCount;
            this.finishCount = finishCount;
        }

        public float getPercent() {
            if (tryCount == 0) return 0;

            return (float) tryCount / (tryCount + finishCount);
        }

        @Override
        public int compareTo(StageInfo o) {
            if (this.getPercent() == o.getPercent()) {
                return this.no - o.no;
            } else {
                return -1 * Float.compare(getPercent(), o.getPercent());
            }
        }
    }

    private static int[] solution1(int N, int[] stages) {

        // 도달 스테이지 카운트
        int[] count = new int[N + 2];
        for (int stage : stages) {
            count[stage]++;
        }
        System.out.println(Arrays.toString(count));

        List<StageInfo> list = new ArrayList<>(); // stage, 실패율
        int finish = count[N + 1];
        for (int i = N; i > 0; i--) {
            list.add(new StageInfo(i, count[i], finish));
            finish += count[i];
        }

        list.sort(null);

        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).no;
        }

        return answer;
    }


    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N + 1];

        int total = 0;
        for (int i = 0; i < stages.length; i++) {
            total += 1;

            if (stages[i] == N + 1)
                continue;

            answer[stages[i]] += 1;
        }

        List<Stage> list = new ArrayList<>();
        for (int i = 1; i < answer.length; i++) {
            list.add(new Stage(i, (float) answer[i] / total));
            total -= answer[i];
        }

        Collections.sort(list);

        int[] result = new int[N];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).getNum();
        }

        return result;
    }

    public static class Stage implements Comparable {
        private int num;
        private float fail;

        public Stage(int num, float fail) {
            this.num = num;
            this.fail = fail;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Object o) {
            Stage s = (Stage) o;

            if (this.fail > s.fail)
                return -1;
            else if (this.fail < s.fail)
                return 1;
            return this.num - s.num;
        }
    }
}
