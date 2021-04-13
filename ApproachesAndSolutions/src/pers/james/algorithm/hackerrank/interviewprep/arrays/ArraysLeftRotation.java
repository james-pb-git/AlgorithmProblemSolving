package pers.james.algorithm.hackerrank.interviewprep.arrays;

/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 */
public class ArraysLeftRotation {

    static int[] rotLeft(int[] a, int d) {

        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 0, a.length - 1);
        return a;

    }

    static void reverse(int[] a, int start, int end) {

        int tmp = 0;
        for (int i = start; i < start + (end - start + 1) / 2; i ++) {
            tmp = a[i];
            a[i] = a[start + end - i];
            a[start + end - i] = tmp;
        }

    }

}
