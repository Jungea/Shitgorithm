package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");

        int[][] rooms = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input3 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(input3[j]);
            }
        }

        Robot robot = new Robot(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]), Integer.parseInt(input2[2]), rooms);

        while (true) {

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            robot.clean();

            boolean isMoved = false;

            // 반시계 방향으로 돌며 청소되지 않은 방을 탐색
            for (int i = 0; i < 4; i++) {
                robot.rotate();
                Position dp = robot.getDirectionPosition();

                if (dp != null && rooms[dp.x][dp.y] == 0) {
                    robot.position = dp;
                    isMoved = true;
                    break;
                }
            }

            if (!isMoved) {
                // 주변 4칸 중 청소되지 않은 방이 없는 경우

                robot.rotate();
                robot.rotate();

                Position dp = robot.getDirectionPosition();

                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (dp == null || rooms[dp.x][dp.y] == 1) {
                    break;

                } else {  // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                    robot.position = dp;
                    robot.rotate();
                    robot.rotate();
                }
            }

        }

        System.out.println(robot.cleaning);
    }

    enum Direction {
        // 0 북, 1 동, 2 남, 3 서
        N(0),
        S(2),
        E(1),
        W(3);

        int no;

        Direction(int no) {
            this.no = no;
        }

        public static Direction getDirectionEnum(int no) {
            for (Direction d : Direction.values()) {
                if (d.no == no) {
                    return d;
                }
            }

            return null;
        }
    }

    static class Robot {
        Position position;
        Direction direction;
        int[][] rooms;
        int cleaning = 0;

        public Robot(int x, int y, int no, int[][] rooms) {
            this.position = new Position(x, y);
            this.direction = Direction.getDirectionEnum(no);
            this.rooms = rooms;
        }

        public Robot(Position position, Direction direction) {
            this.position = position;
            this.direction = direction;
        }

        /**
         * 바라보고 있는 방향의 좌표
         *
         * @return
         */
        public Position getDirectionPosition() {
            if (direction == Direction.N && this.position.x > 0) {
                return new Position(this.position.x - 1, this.position.y);
            } else if (direction == Direction.E && this.position.y < this.rooms[0].length - 1) {
                return new Position(this.position.x, this.position.y + 1);
            } else if (direction == Direction.S && this.position.x < this.rooms.length - 1) {
                return new Position(this.position.x + 1, this.position.y);
            } else if (direction == Direction.W && this.position.y > 0) {
                return new Position(this.position.x, this.position.y - 1);
            }

            return null;
        }

        /**
         * 반시계방향으로 회전
         */
        public void rotate() {
            this.direction = Direction.getDirectionEnum((this.direction.no - 1 + 4) % 4);
        }

        public void clean() {
            if (rooms[this.position.x][this.position.y] == 0) {
                rooms[position.x][position.y] = 2;
                cleaning++;
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
