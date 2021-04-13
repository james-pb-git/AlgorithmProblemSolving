package pers.james.algorithm.hackerrank.interviewprep.arrays;

/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/minimum-swaps-2
 */
public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {

        int count = 0;
        for (int idx = 0; idx < arr.length; idx ++) {
            while (arr[idx] != idx + 1) {
                swap(arr, idx, arr[idx] - 1);
                count ++;
            }
        }
        return count;
    }

    private static void swap(int[] arr, int left, int right) {

        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;

    }

}
