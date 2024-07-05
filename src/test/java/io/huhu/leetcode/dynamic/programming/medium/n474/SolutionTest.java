package io.huhu.leetcode.dynamic.programming.medium.n474;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        Assertions.assertEquals(4, solution.findMaxForm(strs, m, n));
    }

    @Test
    void test2() {
        String[] strs = {"10", "0", "1"};
        int m = 1, n = 1;
        Assertions.assertEquals(2, solution.findMaxForm(strs, m, n));
    }

}
