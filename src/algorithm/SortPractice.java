package algorithm;

import java.util.Arrays;
import java.util.function.Consumer;

public class SortPractice {
    public static void main(String[] args) {
        int[] original = {5, 3, 8, 4, 2};

        test("버블 정렬", original, SortPractice::bubbleSort);
        test("선택 정렬", original, SortPractice::selectionSort);
//        test("삽입 정렬", original, SortPractice::insertionSort);
//        test("퀵 정렬", original, SortPractice::quickSort);
//        test("병합 정렬", original, SortPractice::mergeSort);
//        test("계수 정렬", original, SortPractice::countingSort); // 정수만 가능
//        test("Arrays.sort()", original, Arrays::sort);

    }

    // 공통 테스트 메서드
    public static void test(String name, int[] source, Consumer<int[]> sorter) {
        int[] copy = Arrays.copyOf(source, source.length);
        sorter.accept(copy);
        System.out.println(name + ": " + Arrays.toString(copy));
    }

    // 버블 정렬
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;  // 최선의 케이스 개선형
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 선택 정렬
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}