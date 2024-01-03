package io.huhu.leetcode.bit.manipulation.easy.n231;

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
    @ValueSource(ints = {1, 4, 16})
    void isPowerOfTwoTrue(int n) {
        Assertions.assertTrue(solution.isPowerOfTwo(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, -16, -2147483648})
    void isPowerOfTwoFalse(int n) {
        Assertions.assertFalse(solution.isPowerOfTwo(n));
    }

}
