package pers.james.algorithm.hackerrank.interviewprep.sorting;

import java.util.*;

/**
 * Created by bopang on 2021-04-21.
 * https://www.hackerrank.com/challenges/mark-and-toys
 */
public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);

        int count = 0;
        int currentTotal = 0;
        for (int price : prices) {

            if (currentTotal + price <= k) {
                currentTotal += price;
                count ++;
            }
            else {
                break;
            }

        }

        return count;

    }
}
