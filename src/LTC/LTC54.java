package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC54 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;


        while (left <= right && top <= bottom) {
            for (int x = left; x <= right; x++) {
                result.add(matrix[top][x]);
            }
            top++;

            for (int y = top; y <= bottom; y++) {
                result.add(matrix[y][right]);
            }
            right--;

            if (left <= right) {
                for (int x = right; x >= left; x--) {
                    result.add(matrix[bottom][x]);
                }
                bottom--;
            }

            if (top <= bottom) {
                for (int y = bottom; y >= top; y--) {
                    result.add(matrix[y][left]);
                }
                left++;
            }
        }

        return result;
    }
}
