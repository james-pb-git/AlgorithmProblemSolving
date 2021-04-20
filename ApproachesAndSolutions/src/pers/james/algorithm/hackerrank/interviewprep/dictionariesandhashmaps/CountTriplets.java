package pers.james.algorithm.hackerrank.interviewprep.dictionariesandhashmaps;

import java.util.*;

/**
 * Created by bopang on 2021-04-20.
 * https://www.hackerrank.com/challenges/count-triplets-1
 */
public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        // This has to be long. Int type would be overloaded.
        long res = 0;

        // A counter of all elements in the array.
        Map<Long, Long> singleCount = new HashMap<>();

        // A counter of all pairs in the array such that pair_1 == pair_0 * r
        Map<Long, Long> pairCount = new HashMap<>();

        for (int idx = 0; idx < arr.size(); idx ++) {

            // Important: check if current element can be divided by r * r
            if (arr.get(idx) / r / r * r * r == arr.get(idx) &&
                    pairCount.containsKey(arr.get(idx) / r / r)) {

                // The new valid triples with the last element being the current number.
                res += pairCount.get(arr.get(idx) / r / r);
            }

            // Again, it's important to ensure the current number can be divided by r.
            if (arr.get(idx) / r * r == arr.get(idx) &&
                    singleCount.containsKey(arr.get(idx) / r)) {

                // Update the count of pairs with the second element being the current number.
                long countOfPair = pairCount.getOrDefault(arr.get(idx) / r, 0L);
                countOfPair += singleCount.get(arr.get(idx) / r);
                pairCount.put(arr.get(idx) / r, countOfPair);
            }

            long count = singleCount.getOrDefault(arr.get(idx), 0L);
            count ++;
            singleCount.put(arr.get(idx), count);

        }

        return res;

    }

}
