package io.huhu.leetcode.back.trace.n51;

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

    /**
     * <img src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg"/>
     */
    @Test
    void case_1() {
        List<List<String>> actual = solution.solveNQueens(4);
        List<List<String>> expected = List.of(List.of(".Q..", "...Q", "Q...", "..Q."), List.of("..Q.", "Q...", "...Q", ".Q.."));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        List<List<String>> actual = solution.solveNQueens(1);
        List<List<String>> expected = List.of(List.of("Q"));
        Assertions.assertIterableEquals(expected, actual);
    }

}
