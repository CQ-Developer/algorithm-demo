package io.huhu.leetcode.binary.tree.hard.n2246;

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
        int[] parent = {-1, 0, 0, 1, 1, 2};
        Assertions.assertEquals(3, solution.longestPath(parent, "abacbe"));
    }

    @Test
    void test_2() {
        int[] parent = {-1, 0, 0, 0};
        Assertions.assertEquals(3, solution.longestPath(parent, "aabc"));
    }

}
