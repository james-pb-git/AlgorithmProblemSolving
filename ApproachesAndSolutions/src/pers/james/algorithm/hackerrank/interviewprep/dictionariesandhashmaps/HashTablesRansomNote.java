package pers.james.algorithm.hackerrank.interviewprep.dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bopang on 2021-04-20.
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 */
public class HashTablesRansomNote {

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> wordCount = new HashMap<>();

        Arrays.stream(magazine).forEach(word -> {

            Integer count = wordCount.getOrDefault(word, 0);
            count ++;
            wordCount.put(word, count);

        });

        for (String word : note) {

            Integer count = wordCount.getOrDefault(word, 0);
            if (count.equals(0)) {
                System.out.println("No");
                return;
            }

            count --;
            wordCount.put(word, count);

        }

        System.out.println("Yes");

    }

}
