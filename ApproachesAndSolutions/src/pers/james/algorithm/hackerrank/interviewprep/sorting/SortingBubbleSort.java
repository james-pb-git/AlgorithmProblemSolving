package pers.james.algorithm.hackerrank.interviewprep.sorting;

/**
 * Created by bopang on 2021-04-21.
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 */
public class SortingBubbleSort {

    static void countSwaps(int[] a) {

        int swaps = 0;

        for (int i = 0; i < a.length; i ++) {

            for (int j = 0; j < a.length - 1; j ++) {

                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaps ++;
                }

            }

        }

        System.out.println(String.format("Array is sorted in %d swaps.", swaps));
        System.out.println(String.format("First Element: %d", a[0]));
        System.out.println(String.format("Last Element: %d", a[a.length - 1]));

    }

    static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
