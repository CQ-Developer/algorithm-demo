package io.huhu.leetcode.dynamic.programming.medium.n397;

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
        Assertions.assertEquals(3, solution.integerReplacement(8));
    }

    @Test
    void test2() {
        Assertions.assertEquals(4, solution.integerReplacement(7));
    }

    @Test
    void test3() {
        Assertions.assertEquals(2, solution.integerReplacement(4));
    }

    @Test
    void test4() {
        Assertions.assertEquals(32, solution.integerReplacement(2147483647));
    }

}
