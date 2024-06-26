package io.huhu.leetcode.dynamic.programming.medium.n983;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DPTest extends SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new DP();
    }

    @Test
    void test1() {
        case_1(solution);
    }

    @Test
    void test2() {
        case_2(solution);
    }

    @Test
    void test3() {
        case_3(solution);
    }

}
