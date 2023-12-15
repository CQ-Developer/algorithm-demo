package io.huhu.leetcode.back.trace.n2375;

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
    void case_1() {
        Assertions.assertEquals("123549876", solution.smallestNumber("IIIDIDDD"));
    }

    @Test
    void case_2() {
        Assertions.assertEquals("4321", solution.smallestNumber("DDD"));
    }

}
