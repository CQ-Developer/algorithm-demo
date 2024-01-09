package io.huhu.leetcode.bit.manipulation.easy.n1342;

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
    void numberOfSteps_1() {
        Assertions.assertEquals(6, solution.numberOfSteps(14));
    }

    @Test
    void numberOfSteps_2() {
        Assertions.assertEquals(4, solution.numberOfSteps(8));
    }

    @Test
    void numberOfSteps_3() {
        Assertions.assertEquals(12, solution.numberOfSteps(123));
    }

    @Test
    void numberOfSteps_4() {
        Assertions.assertEquals(0, solution.numberOfSteps(0));
    }

}
