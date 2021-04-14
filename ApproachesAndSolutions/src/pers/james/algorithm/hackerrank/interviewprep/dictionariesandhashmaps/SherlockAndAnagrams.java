package pers.james.algorithm.hackerrank.interviewprep.dictionariesandhashmaps;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bopang on 2021-04-14.
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 *
 */
public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> subStringCount = new HashMap<>();

        // Go over substrings. Note: substring is different from subsequence.
        for (int left = 0; left < s.length(); left ++) {

            for (int right = left + 1; right <= s.length(); right ++) {

                String identifer = extractIdentifer(s.substring(left, right));
                int count = subStringCount.getOrDefault(identifer, 0);
                count ++;
                subStringCount.put(identifer, count);

            }

        }

        int result = 0;
        for (Map.Entry<String, Integer> entry: subStringCount.entrySet()) {

            result += entry.getValue() * (entry.getValue() - 1) / 2;

        }

        return result;

    }

    private static String extractIdentifer(String s) {

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);

    }


}
