package pers.james.algorithm.hackerrank.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class CountingValleys {

    public static int countingValleys(int steps, String path) {

        int previous = 0;
        int current = 0;
        int valleys = 0;
        for (char step : path.toCharArray()) {

            if (step == 'U') {
                current = previous + 1;
            } else {
                current = previous - 1;
            }

            if (previous == 0 && current < 0) {
                valleys ++;
            }

            previous = current;

        }

        return valleys;

    }

}
