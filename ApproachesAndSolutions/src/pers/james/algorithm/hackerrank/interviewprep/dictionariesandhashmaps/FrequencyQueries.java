package pers.james.algorithm.hackerrank.interviewprep.dictionariesandhashmaps;

import java.util.*;

/**
 * Created by bopang on 2021-04-21.
 * https://www.hackerrank.com/challenges/frequency-queries
 */
public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        Map<Integer, Integer> valueMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        for (List<Integer> query : queries) {

            // Insertion
            if (query.get(0).equals(1)) {

                int updatedCount = addOneToMap(valueMap, query.get(1));
                addOneToMap(countMap, updatedCount);
                deductOneFromMap(countMap, updatedCount - 1);

            }

            // Deletion
            else if (query.get(0).equals(2)) {

                int updatedCount = deductOneFromMap(valueMap, query.get(1));
                if (updatedCount > 0) {
                    addOneToMap(countMap, updatedCount);
                }
                deductOneFromMap(countMap, updatedCount + 1);

            }

            // Query
            else if (query.get(0).equals(3)) {

                res.add(countMap.containsKey(query.get(1))? 1 : 0);

            }

        }

        return res;

    }

    static int addOneToMap(Map<Integer, Integer> counter, Integer key) {

        int count = counter.getOrDefault(key, 0);
        count ++;
        counter.put(key, count);

        return count;

    }

    // Returning value could be -1, which indicates the element didn't exist.
    // It's necessary to differentiate the cases where the element existed or not before
    // deducting, to update countMap accurately.
    static int deductOneFromMap(Map<Integer, Integer> counter, Integer key) {

        int count = counter.getOrDefault(key, 0);
        count --;

        if (count > 0) {
            counter.put(key, count);
        } else {
            counter.remove(key);
        }

        return count;

    }

}
