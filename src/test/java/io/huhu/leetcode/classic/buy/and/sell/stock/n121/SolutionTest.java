package io.huhu.leetcode.classic.buy.and.sell.stock.n121;

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
    void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, solution.maxProfit(prices));
    }

    @Test
    void test2() {
        int[] prices = {7, 6, 4, 3, 1};
        Assertions.assertEquals(0, solution.maxProfit(prices));
    }

}
