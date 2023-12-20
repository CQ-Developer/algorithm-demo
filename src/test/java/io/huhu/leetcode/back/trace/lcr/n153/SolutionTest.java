package io.huhu.leetcode.back.trace.lcr.n153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        List<List<Integer>> actual = solution.pathTarget(root, 22);
        List<List<Integer>> expected = List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        List<List<Integer>> actual = solution.pathTarget(root, 5);
        List<List<Integer>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null);
        List<List<Integer>> actual = solution.pathTarget(root, 0);
        List<List<Integer>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_4() {
        List<List<Integer>> actual = solution.pathTarget(null, 1);
        List<List<Integer>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_5() {
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        List<List<Integer>> actual = solution.pathTarget(root, -5);
        List<List<Integer>> expected = List.of(List.of(-2, -3));
        Assertions.assertIterableEquals(expected, actual);
    }

}
