package io.huhu.algorithm.leetcode.n51;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        List<List<String>> list = List.of(
                List.of(".Q..", "...Q", "Q...", "..Q."),
                List.of("..Q.", "Q...", "...Q", ".Q.."));
        assertIterableEquals(list, solution.solveNQueens(4));
    }

    @Test
    void test2() {
        List<List<String>> list = List.of(List.of("Q"));
        assertIterableEquals(list, solution.solveNQueens(1));
    }

}
