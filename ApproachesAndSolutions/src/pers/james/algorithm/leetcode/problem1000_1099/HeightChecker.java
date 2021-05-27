package pers.james.algorithm.leetcode.problem1000_1099;

/**
 * Created by bopang on 2021-05-27.
 * https://leetcode.com/problems/height-checker/
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {

        int[] counter = new int[101];
        for(int height : heights) {
            counter[height] ++;
        }

        int res = 0;
        int curCnt = 0;
        int expected = 1;
        for (int idx = 0; idx < heights.length; idx ++) {

            while(expected <= 100 && curCnt >= counter[expected]) {

                expected ++;
                curCnt = 0;

            }

            curCnt ++;
            if (expected != heights[idx]) {
                res ++;
            }
        }

        return res;

    }

}
