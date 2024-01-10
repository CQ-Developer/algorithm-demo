package io.huhu.leetcode.bit.manipulation.easy.n2869;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void minOperations_1() {
        Assertions.assertEquals(4, solution.minOperations(List.of(3, 1, 5, 4, 2), 2));
    }

    @Test
    void minOperations_2() {
        Assertions.assertEquals(5, solution.minOperations(List.of(3, 1, 5, 4, 2), 5));
    }

    @Test
    void minOperations_3() {
        Assertions.assertEquals(4, solution.minOperations(List.of(3, 2, 5, 3, 1), 3));
    }

}
