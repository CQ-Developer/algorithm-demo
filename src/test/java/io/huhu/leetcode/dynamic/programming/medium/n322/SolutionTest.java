package io.huhu.leetcode.dynamic.programming.medium.n322;

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
        int[] coins = {1, 2, 5};
        Assertions.assertEquals(3, solution.coinChange(coins, 11));
    }

    @Test
    void test2() {
        int[] coins = {2};
        Assertions.assertEquals(-1, solution.coinChange(coins, 3));
    }

    @Test
    void test3() {
        int[] coins = {1};
        Assertions.assertEquals(0, solution.coinChange(coins, 0));
    }

    @Test
    void test4() {
        int[] coins = {1, 2147483647};
        Assertions.assertEquals(2, solution.coinChange(coins, 2));
    }

    @Test
    void test5() {
        int[] coins = {1, 2, 5};
        Assertions.assertEquals(20, solution.coinChange(coins, 100));
    }

    @Test
    void test6() {
        int[] coins = {1};
        Assertions.assertEquals(2, solution.coinChange(coins, 2));
    }

    @Test
    void test7() {
        int[] coins = {186, 419, 83, 408};
        Assertions.assertEquals(20, solution.coinChange(coins, 6249));
    }

}
