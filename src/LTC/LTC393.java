package LTC;

public class LTC393 {

    public static void main(String[] args) {
        int[] a = new int[]{197, 130, 1};

        for (int i : a) {
            System.out.println(Integer.toBinaryString(i));
        }

        System.out.println(validUtf8(a));
    }

    public static boolean validUtf8(int[] data) {

        int start = 0;

        while (start < data.length) {
            int first = data[start];
            if (first >> 3 == 0b11110 && check(data, start, 3)) {
                start += 4;
            } else if (first >> 4 == 0b1110 && check(data, start, 2)) {
                start += 3;
            } else if (first >> 5 == 0b110 && check(data, start, 1)) {
                start += 2;
            } else if (first >> 7 == 0b0) {
                start++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean check(int[] data, int start, int size) {
        for (int i = start + 1; i < start + 1 + size; i++) {
            if (i >= data.length || data[i] >> 6 != 0b10)
                return false;
        }

        return true;
    }
}
