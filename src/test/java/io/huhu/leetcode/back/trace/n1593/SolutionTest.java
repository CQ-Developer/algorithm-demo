package io.huhu.leetcode.back.trace.n1593;

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
    void case1() {
        Assertions.assertEquals(5, solution.maxUniqueSplit("ababccc"));
    }

    @Test
    void case2() {
        Assertions.assertEquals(2, solution.maxUniqueSplit("aba"));
    }

    @Test
    void case3() {
        Assertions.assertEquals(1, solution.maxUniqueSplit("aa"));
    }

}
