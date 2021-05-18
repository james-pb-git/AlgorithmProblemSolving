package pers.james.algorithm.leetcode.problem1000_1099;

/**
 * Created by bopang on 2021-05-18.
 * https://leetcode.com/problems/duplicate-zeros/
 * Future improvements:
 * modifiedLength = length + countOfZero * 2;
 * "Pretend" to write from modifiedLenght - 1 but only actually write it in the range of array.
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {

        int lastIndex = -1;
        boolean doubleZero = false;

        int modifiedLength = 0;

        for (int idx = 0; idx < arr.length; idx ++) {

            modifiedLength ++;

            if (modifiedLength == arr.length) {

                lastIndex = idx;
                break;
            }

            if (arr[idx] == 0) {

                // The second zero
                modifiedLength ++;
                if (modifiedLength == arr.length) {
                    lastIndex = idx;
                    doubleZero = true;
                    break;
                }

            }
        }

        int srcIdx = lastIndex;
        for (int idx = arr.length - 1; idx >= 0; idx --) {

            if (arr[srcIdx] == 0) {

                arr[idx] = 0;

                if (idx != arr.length - 1 || doubleZero) {
                    idx --;
                    arr[idx] = 0;
                }

                srcIdx --;

            } else {
                arr[idx] = arr[srcIdx];
                srcIdx --;
            }

        }
    }

}
