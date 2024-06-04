package io.huhu.leetcode.dynamic.programming.core.ugly.number.n1201;

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
        Assertions.assertEquals(4, solution.nthUglyNumber(3, 2, 3, 5));
    }

    @Test
    void test2() {
        Assertions.assertEquals(6, solution.nthUglyNumber(4, 2, 3, 4));
    }

    @Test
    void test3() {
        Assertions.assertEquals(10, solution.nthUglyNumber(5, 2, 11, 13));
    }

}
