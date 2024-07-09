package io.huhu.leetcode.binary.search.medium.n875;

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
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        Assertions.assertEquals(4, solution.minEatingSpeed(piles, h));
    }

    @Test
    void test2() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        Assertions.assertEquals(30, solution.minEatingSpeed(piles, h));
    }

    @Test
    void test3() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        Assertions.assertEquals(23, solution.minEatingSpeed(piles, h));
    }

    @Test
    void test4() {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        Assertions.assertEquals(3, solution.minEatingSpeed(piles, h));
    }

}
