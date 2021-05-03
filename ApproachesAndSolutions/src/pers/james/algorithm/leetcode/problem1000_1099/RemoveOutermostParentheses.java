package pers.james.algorithm.leetcode.problem1000_1099;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 2021-05-03.
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * Easier solutions exist: Count open parentheses and update result only when open number > 1.
 */
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {

        StringBuilder result = new StringBuilder();

        List<Character> stack = new ArrayList<>();

        for (Character ch : S.toCharArray()) {

            if (stack.isEmpty()) {
                stack.add(ch);
            } else if (stack.size() == 1 && ch.equals(')')) {
                stack.remove(stack.size() - 1);
            } else {

                result.append(ch);
                if (ch.equals('(')) {
                    stack.add(ch);
                } else {
                    stack.remove(stack.size() - 1);
                }

            }

        }

        return result.toString();
    }

}
