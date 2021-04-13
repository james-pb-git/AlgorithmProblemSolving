package pers.james.algorithm.hackerrank.interviewprep.warmup;

/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {

        if (c == null || c.length == 0) {
            return 0;
        }

        int pos = 0;
        int jumps = 0;
        while (pos < c.length - 1) {

            if (pos + 2 <= c.length - 1 && c[pos + 2] == 0) {
                pos += 2;
                jumps += 1;
            } else if (pos + 1 <= c.length - 1 && c[pos + 1] == 0) {
                pos += 1;
                jumps += 1;
            }

        }

        return jumps;

    }

}
