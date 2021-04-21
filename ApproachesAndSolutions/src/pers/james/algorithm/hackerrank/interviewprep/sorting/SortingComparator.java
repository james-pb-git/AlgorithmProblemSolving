package pers.james.algorithm.hackerrank.interviewprep.sorting;

import java.util.Comparator;

/**
 * Created by bopang on 2021-04-21.
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting
 */
public class SortingComparator {

    class Checker implements Comparator<Player> {
        // complete this method
        public int compare(Player a, Player b) {

            if (a.score != b.score) {
                return b.score - a.score;
            }

            return a.name.compareTo(b.name);

        }
    }

}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
