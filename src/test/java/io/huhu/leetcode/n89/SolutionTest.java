package io.huhu.leetcode.n89;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void grayCode1() {
        assertIterableEquals(List.of(0, 1, 3, 2), solution.grayCode(2));
    }

    @Test
    void grayCode2() {
        assertIterableEquals(List.of(0, 1), solution.grayCode(1));
    }

}
