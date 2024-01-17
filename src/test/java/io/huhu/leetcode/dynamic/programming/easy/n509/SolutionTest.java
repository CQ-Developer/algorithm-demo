package io.huhu.leetcode.dynamic.programming.easy.n509;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void fib_1() {
        Assertions.assertEquals(1, solution.fib(2));
    }

    @Test
    void fib_2() {
        Assertions.assertEquals(2, solution.fib(3));
    }

    @Test
    void fib_3() {
        Assertions.assertEquals(3, solution.fib(4));
    }

    @Test
    void fib_4() {
        Assertions.assertEquals(196418, solution.fib(27));
    }

    @Test
    void fib_5() {
        Assertions.assertEquals(0, solution.fib(0));
    }

    @Test
    void fib_6() {
        Assertions.assertEquals(34, solution.fib(9));
    }

    @Test
    void fib_7() {
        Assertions.assertEquals(1, solution.fib(1));
    }

}
