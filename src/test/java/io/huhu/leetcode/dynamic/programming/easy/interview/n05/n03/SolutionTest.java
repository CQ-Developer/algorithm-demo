package io.huhu.leetcode.dynamic.programming.easy.interview.n05.n03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        assertEquals(8, solution.reverseBit(1775));
    }

    @Test
    void test_2() {
        assertEquals(4, solution.reverseBit(7));
    }

}
