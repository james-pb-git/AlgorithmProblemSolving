package pers.james.algorithm.leetcode.misc;

/**
 * Created by bopang on 2021-04-13.
 * https://leetcode.com/problems/closest-dessert-cost/
 */
public class ClosestDessertCost {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        int minVal = Integer.MAX_VALUE;
        int[] minValWithBaseCosts = new int[1];
        for (int idx = 0; idx < baseCosts.length; idx ++) {

            minValWithBaseCosts[0] = Integer.MAX_VALUE;

            closestCostRecursion(baseCosts[idx], 0, toppingCosts, target, 0, minValWithBaseCosts);

            if ( Math.abs(minValWithBaseCosts[0] - target) < Math.abs(minVal - target) ) {
                minVal = minValWithBaseCosts[0];
            } else if (Math.abs(minValWithBaseCosts[0] - target) == Math.abs(minVal - target) ) {
                minVal = Math.min(minValWithBaseCosts[0], minVal);
            }
        }
        return minVal;
    }

    private void closestCostRecursion(int baseCost, int index, int[] toppingCosts, int target, int currentCost, int[] minVal) {

        if (index == 0) {
            currentCost += baseCost;
        }

        if (index == toppingCosts.length) {

            if ( Math.abs(currentCost - target) < Math.abs( minVal[0] - target)) {
                minVal[0] = currentCost;
            } else if (Math.abs(currentCost - target) == Math.abs(minVal[0] -target)) {
                minVal[0] = Math.min(minVal[0], currentCost);
            }

            return;

        }

        for (int toppings = 0; toppings <= 2; toppings ++) {

            closestCostRecursion(baseCost, index + 1, toppingCosts, target, currentCost + toppings * toppingCosts[index], minVal);

        }

    }

}
