package io.huhu.leetcode.back.trace.n1774;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;
        Assertions.assertEquals(10, solution.closestCost(baseCosts, toppingCosts, target));
    }

    @Test
    void case_2() {
        int[] baseCosts = {2, 3};
        int[] toppingCosts = {4, 5, 100};
        int target = 18;
        Assertions.assertEquals(17, solution.closestCost(baseCosts, toppingCosts, target));
    }

    @Test
    void case_3() {
        int[] baseCosts = {3, 10};
        int[] toppingCosts = {2, 5};
        int target = 9;
        Assertions.assertEquals(8, solution.closestCost(baseCosts, toppingCosts, target));
    }

    @Test
    void case_4() {
        int[] baseCosts = {10};
        int[] toppingCosts = {1};
        int target = 1;
        Assertions.assertEquals(10, solution.closestCost(baseCosts, toppingCosts, target));
    }

}
