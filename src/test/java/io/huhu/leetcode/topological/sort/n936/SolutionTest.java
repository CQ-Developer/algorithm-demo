package io.huhu.leetcode.topological.sort.n936;

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
    void test_1() {
        int[] actual = solution.movesToStamp("abc", "ababc");
        int[] expected = {1, 0, 2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_2() {
        int[] actual = solution.movesToStamp("abca", "aabcaca");
        int[] expected = {2, 3, 0, 1};
        Assertions.assertArrayEquals(expected, actual);
    }

}
