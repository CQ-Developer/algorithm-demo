package io.huhu.leetcode.bit.manipulation.easy.n342;

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
    @ValueSource(ints = {1, 16})
    void isPowerOfFourTrue(int n) {
        Assertions.assertTrue(solution.isPowerOfFour(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, 0, 2, 5, 8})
    void isPowerOfFourFalse(int n) {
        Assertions.assertFalse(solution.isPowerOfFour(n));
    }

}
