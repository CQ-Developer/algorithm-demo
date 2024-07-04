package io.huhu.leetcode.dynamic.programming.hard.n115;

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
        Assertions.assertEquals(3, solution.numDistinct("rabbbit", "rabbit"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(5, solution.numDistinct("babgbag", "bag"));
    }

}
