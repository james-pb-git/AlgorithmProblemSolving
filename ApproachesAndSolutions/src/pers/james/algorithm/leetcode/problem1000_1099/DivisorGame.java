package pers.james.algorithm.leetcode.problem1000_1099;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bopang on 2021-05-03.
 * https://leetcode.com/problems/divisor-game/
 *
 * Easier solutions exist: return n % 2 == 0
 *
 */
public class DivisorGame {

    public boolean divisorGame(int n) {

        Map<Integer, Boolean> resultCache = new HashMap<>();

        return divisorGameRecursion(n, resultCache);

    }

    private boolean divisorGameRecursion(int n, Map<Integer, Boolean> cache) {

        if (n == 1) return false;

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        for (int num = 1; num < n; num ++) {

            if (n % num != 0) {
                continue;
            }

            if (!divisorGameRecursion(n - num, cache)) {
                cache.put(n, true);
                return true;
            }
        }

        cache.put(n, false);
        return false;

    }

}
