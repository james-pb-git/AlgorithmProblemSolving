package pers.james.algorithm.hackerrank.interviewprep.warmup;

import java.util.stream.IntStream;

/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/repeated-string
 */
public class RepeatedString {

    static long repeatedString(String s, long n) {

        int occurence = IntStream.range(0, s.length())
                .map(idx -> (s.charAt(idx) == 'a'? 1 : 0))
                .sum();

        String remainedString = s.substring(0, (int) (n % s.length()));

        int remainedOccurence = IntStream.range(0, remainedString.length())
                .map(idx -> (remainedString.charAt(idx) == 'a'? 1 : 0))
                .sum();

        return occurence * (n / s.length()) + remainedOccurence;

    }

}
