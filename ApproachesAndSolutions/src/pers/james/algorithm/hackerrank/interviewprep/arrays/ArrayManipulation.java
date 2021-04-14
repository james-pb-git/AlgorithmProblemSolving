package pers.james.algorithm.hackerrank.interviewprep.arrays;

import java.util.*;

/**
 * Created by bopang on 2021-04-14.
 * https://www.hackerrank.com/challenges/crush
 */
public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {

        int[][] pairs = convertQueriesToPairs(queries);

        // Using Lambda to define Comparator.
        Arrays.sort(pairs, (pair1, pair2) -> (pair1[0] - pair2[0]));

        long currentValue = 0;
        long maxValue = Long.MIN_VALUE;
        for (int idx = 0; idx < pairs.length; idx ++) {

            currentValue += pairs[idx][1];

            if (idx + 1 < pairs.length && pairs[idx + 1][0] == pairs[idx][0]) {
                continue;
            }

            maxValue = Math.max(maxValue, currentValue);

        }

        return maxValue;

    }

    private static int[][] convertQueriesToPairs(int[][] queries) {

        int[][] pairs = new int[queries.length * 2][2];

        for (int idx = 0; idx < queries.length; idx ++) {

            pairs[idx * 2][0] = queries[idx][0];
            pairs[idx * 2][1] = queries[idx][2];

            // Note: the index is inclusive! Minus one on the next index.
            pairs[idx * 2 + 1][0] = queries[idx][1] + 1;
            pairs[idx * 2 + 1][1] = -queries[idx][2];

        }

        return pairs;

    }
}
