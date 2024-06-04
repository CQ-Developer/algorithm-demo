package io.huhu.leetcode.dynamic.programming.medium.n313;

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
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        Assertions.assertEquals(32, solution.nthSuperUglyNumber(n, primes));
    }

    @Test
    void test2() {
        int n = 1;
        int[] primes = {2, 3, 5};
        Assertions.assertEquals(1, solution.nthSuperUglyNumber(n, primes));
    }

}