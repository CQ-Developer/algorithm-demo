package io.huhu.leetcode.dynamic.programming.hard.n629;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DPTest extends SolutionTest {

    @Override
    Solution getSolution() {
        return new DP();
    }

    @Test
    void test() {
        Assertions.assertEquals(0, solution.kInversePairs(2, 2));
    }

}
