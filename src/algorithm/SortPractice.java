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

    // 삽입 정렬
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    // 퀵 정렬
    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[(low + high) / 2];
        int left = low, right = high;
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) swap(arr, left++, right--);
        }
        quickSortRecursive(arr, low, right);
        quickSortRecursive(arr, left, high);
    }

    // 병합 정렬
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, idx = 0;
        while (i < left.length && j < right.length) {
            arr[idx++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[idx++] = left[i++];
        while (j < right.length) arr[idx++] = right[j++];
    }

    // 계수 정렬 (0 이상 정수 전용)
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int[] count = new int[max + 1];
        for (int n : arr) count[n]++;
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) arr[idx++] = i;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}