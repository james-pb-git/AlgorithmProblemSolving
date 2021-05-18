package pers.james.algorithm.leetcode.problem1000_1099;

import java.util.*;

/**
 * Created by bopang on 2021-05-18.
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 * Future improvements: intersection solution - value i is feasible if:
 * countInTops(i) + countInBottoms(i) - countInIntersection(i) = length.
 */
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {

        Map<Integer, Integer> cntOfOccur = new HashMap<>();

        for (int idx = 0; idx < tops.length; idx ++) {

            int count = cntOfOccur.getOrDefault(tops[idx], 0);
            count ++;
            cntOfOccur.put(tops[idx], count);

            if (tops[idx] == bottoms[idx]) {
                continue;
            }

            count = cntOfOccur.getOrDefault(bottoms[idx], 0);
            count ++;
            cntOfOccur.put(bottoms[idx], count);

        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : cntOfOccur.entrySet()) {

            if (entry.getValue() == tops.length) {

                int swaps1 = 0;
                int swaps2 = 0;
                for (int idx = 0; idx < tops.length; idx ++) {
                    if (tops[idx] != entry.getKey()) {
                        swaps1 ++;
                    }
                    if (bottoms[idx] != entry.getKey()) {
                        swaps2 ++;
                    }
                }

                if (ans == -1) {
                    ans = Math.min(swaps1, swaps2);
                } else {
                    ans = Math.min(ans, Math.min(swaps1, swaps2));
                }

            }

        }

        return ans;

    }

}
