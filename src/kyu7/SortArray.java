package kyu7;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,6,5};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    public static <T> T[] sortArray(T[] array) {
        Arrays.sort(array, (x, y) -> x.toString().compareTo(y.toString()));
        return array;
    }
}

class Something {
    @Override
    public String toString() {
        return this.toString();
    }
}
