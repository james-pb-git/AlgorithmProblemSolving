package pers.james.algorithm.hackerrank.interviewprep.arrays;

/**
 * Created by bopang on 2021-04-13.
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class NewYearChaos {

    static void minimumBribes(int[] q) {

        // For easier comparison with the index
        for (int i = 0; i < q.length; i++) {
            q[i]--;
        }

        int moves = 0;
        for (int i = q.length - 1; i >= 0; i--) {

            // q[i] is the original position of the person who stands at position i.

            // No one can move more than two positions than his/her original position.
            if (q[i] - i > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = i - 1; j >= 0; j--) {

                // Count the number of bribes person q[i] RECEIVED.
                // If a person with larger number appears ahead of q[i], (s)he must
                // have bribed q[i]
                if (q[j] > q[i]) {
                    moves++;
                }

                // Pruning: If any one bribed q[i], the limit (s)he can reach is
                // one position before q[i]'s original position.
                if (j < q[i] - 1) {
                    break;
                }
            }

        }
        System.out.println(moves);
    }
}
