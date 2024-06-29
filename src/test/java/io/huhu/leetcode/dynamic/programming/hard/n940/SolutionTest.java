package io.huhu.leetcode.dynamic.programming.hard.n940;

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
        Assertions.assertEquals(7, solution.distinctSubseqII("abc"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(6, solution.distinctSubseqII("aba"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(3, solution.distinctSubseqII("aaa"));
    }

}
