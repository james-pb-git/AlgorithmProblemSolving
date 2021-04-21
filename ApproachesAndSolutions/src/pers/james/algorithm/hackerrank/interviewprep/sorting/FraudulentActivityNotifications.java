package pers.james.algorithm.hackerrank.interviewprep.sorting;

import java.util.*;

/**
 * Created by bopang on 2021-04-21.
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications
 */
public class FraudulentActivityNotifications {

    private static int MAX_VALUE = 200;
    private static int[] counter = new int[MAX_VALUE + 1]; // [0, 200]

    static int activityNotifications(int[] expenditure, int d) {

        int count = 0;

        for (int idx = 0; idx < expenditure.length; idx ++) {

            if (idx < d) {
                continue;
            }

            int median2 = findMedian2CountingSort(expenditure, idx - d, idx - 1);

            if (expenditure[idx] >= median2) {
                count ++;
            }

        }

        return count;

    }

    /**
     * This method returns the median value multiplied by 2. This way it's always an
     * integer, and according to the logic only median * 2 is needed.
     **/
    private static int findMedian2CountingSort(int arr[], int left, int right) {

        if (left == 0) {

            Arrays.fill(counter, 0);
            for (int idx = left; idx <= right; idx ++) {
                counter[arr[idx]] ++;
            }

        } else {

            // No need to construct the counter from scratch every time.
            counter[arr[left - 1]] --;
            counter[arr[right]] ++;
        }

        int length = right - left + 1;

        // Be careful here.
        int target = length / 2 + 1;
        if ((length >> 1 << 1) != length) { // odd number

            return findIthNumberInCounter(target) * 2;

        } else { // even number

            return findIthNumberInCounter(target - 1) +
                    findIthNumberInCounter(target);

        }

    }

    private static int findIthNumberInCounter(int target) {

        int count = 0;
        int idx = -1;
        while (count < target) {

            idx ++;
            count += counter[idx];

        }

        return idx;
    }

    private static double findMedian(int[] arr, int left, int right) {

        // Creating new array in every iteration is certainly time-consuming.
        int[] tmpArr = new int[right - left + 1];

        for (int idx = left; idx <= right; idx ++) {
            tmpArr[idx - left] = arr[idx];
        }

        // Always remember faster methods exist to sort integers (than general decimal numbers.)
        Arrays.sort(tmpArr);

        if (tmpArr.length % 2 == 1) {
            return tmpArr[tmpArr.length / 2];
        }

        return (tmpArr[tmpArr.length / 2 - 1] + tmpArr[tmpArr.length / 2] + 0.0) / 2;

    }


}
