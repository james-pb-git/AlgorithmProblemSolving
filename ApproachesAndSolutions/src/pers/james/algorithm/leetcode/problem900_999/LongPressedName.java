package pers.james.algorithm.leetcode.problem900_999;

/**
 * Created by bopang on 2021-05-27.
 * https://leetcode.com/problems/long-pressed-name/
 */
public class LongPressedName {

    /**
     * Learning:
     * 1. ensure idx > 0 before visiting typedArr[idx - 1]; e.g: "a", "b"
     * 2. Ending state: both pointers should be at the end; e.g. "abc", "abcdd";
     * 3. Duplicated characters in the end of typed: "abc", "abcc";
     *
     * Check solution 2 below which handles them elegantly.
     */
    public boolean isLongPressedName(String name, String typed) {

        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();

        int left = 0;
        int right = 0;

        while (left < nameArr.length && right < typedArr.length) {

            if (nameArr[left] == typedArr[right]) {
                left ++;
                right ++;
            } else {

                while(right > 0 && right < typedArr.length && typedArr[right - 1] == typedArr[right]) {
                    right ++;
                }

                if (right < typedArr.length && nameArr[left] == typedArr[right]) {
                    left ++;
                    right ++;
                } else {
                    return false;
                }
            }
        }

        while(right > 0 && right < typedArr.length && typedArr[right - 1] == typedArr[right]) {
            right ++;
        }

        return left == nameArr.length && right == typedArr.length;

    }

    /**
     * Credit: https://leetcode.com/problems/long-pressed-name/discuss/183994/C%2B%2BJavaPython-Two-Pointers
     * Learning:
     */
    public boolean isLongPressedName2(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j)
            if (i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        return i == m;
    }

}
