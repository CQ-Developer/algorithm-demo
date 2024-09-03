package io.huhu.leetcode.dynamic.programming.hard.n465;

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
    void test_1() {
        int[][] transactions = {{0, 1, 10}, {2, 0, 5}};
        Assertions.assertEquals(2, solution.minTransfers(transactions));
    }

}
