package pers.james.algorithm.hackerrank.interviewprep.arrays;

/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/2d-array
 */
public class TwoDimensionalArray {

    static int hourglassSum(int[][] arr) {

        int result = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                current = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] +
                        arr[i][j] +
                        arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];

                result = Math.max(result, current);

            }
        }
        return result;
    }

}
