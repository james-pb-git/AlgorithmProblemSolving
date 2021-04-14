package pers.james.algorithm.hackerrank.interviewprep.dictionariesandhashmaps;

import java.util.*;

/**
 * Created by bopang on 2021-04-14.
 * https://www.hackerrank.com/challenges/two-strings
 */
public class TwoStrings {

    static String twoStrings(String s1, String s2) {

        // Create HashSet from s1
        Set<Character> charSet = new HashSet<>();
        for (char ch : s1.toCharArray()) {
            charSet.add(ch);
        }

        for (char ch : s2.toCharArray()) {

            if (charSet.contains(ch)) {
                return "YES";
            }

        }

        return "NO";

    }


}
