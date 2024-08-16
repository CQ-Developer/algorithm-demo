package io.huhu.leetcode.binary.tree.medium.n103;

import java.util.List;

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
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> actual = solution.zigzagLevelOrder(root);
        List<List<Integer>> expected = List.of(List.of(3), List.of(20, 9), List.of(15, 7));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test_2() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> actual = solution.zigzagLevelOrder(root);
        List<List<Integer>> expected = List.of(List.of(1));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test_3() {
        List<List<Integer>> actual = solution.zigzagLevelOrder(null);
        List<List<Integer>> expected = List.of();
        Assertions.assertIterableEquals(expected, actual);
    }

}
