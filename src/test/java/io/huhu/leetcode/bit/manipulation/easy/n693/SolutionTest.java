package io.huhu.leetcode.bit.manipulation.easy.n693;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 1431655765})
    void hasAlternatingBits_true(int n) {
        Assertions.assertTrue(solution.hasAlternatingBits(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 7, 8, 11, 17})
    void hasAlternatingBits_false(int n) {
        Assertions.assertFalse(solution.hasAlternatingBits(n));
    }

}
